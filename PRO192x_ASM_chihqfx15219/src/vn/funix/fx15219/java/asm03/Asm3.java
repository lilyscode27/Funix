package vn.funix.fx15219.java.asm03;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import static vn.funix.fx15219.java.asm02.Asm2.isAccountBalanceValid;
import static vn.funix.fx15219.java.asm02.Asm2.isAccountNumberValid;

public class Asm3 {


    /*** CONSTANTS ****/
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank digitalBank = new DigitalBank();
    public static final String author = "FX15219";
    public static final String version = "v3.0.0";
    private static final String CUSTOMER_ID = "011111111111";
    private static final String CUSTOMER_NAME = "Funix";


    /*** MAIN FUNCTION ***/
    public static void main(String[] args) {

        // Display start-up menu
        Utils.getDivider();
        System.out.printf("| %s | %s@%s%12s|%n", "DIGITAL BANK", author, version, " ");
        Utils.getDivider();
        System.out.println("1. Display customer's information");
        System.out.println("2. Add a savings account");
        System.out.println("3. Add a loan account");
        System.out.println("4. Make a withdrawal");
        System.out.println("5. Display transaction history");
        System.out.println("0. Exit");
        System.out.println("Note: Enter \"-1\" to exit any function");
        Utils.getDivider();

        // Set up customer
        DigitalCustomer customer = new DigitalCustomer();
        customer.setCustomerName(CUSTOMER_NAME);
        customer.setCustomerId(CUSTOMER_ID);
        digitalBank.addCustomer(customer);

        int choice = -1;
        while (choice != 0) {
            // Generate new choice & Handle invalid choice
            try {
                System.out.print("\nEnter choice: ");
                choice = sc.nextInt();
                if (choice < 0 || choice > 5) {
                    System.out.println("Error: Invalid choice. Try again.");
                    sc.nextLine();

                    // Reset choice
                    choice = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid choice. Try again.");
                sc.nextLine();
            }

            /*** Function 1: Display customer's information ***/
            if (choice == 1) {
                customer.showCustomerInfo();
            }

            /*** Function 2, 3: Add a savings/loan account ***/
            else if (choice == 2 || choice == 3) {

                // Step 1/3: Ask for account number
                System.out.print("Enter new account number: ");
                sc.nextLine();
                String accountNumber = sc.nextLine().trim();

                while ((!isAccountNumberValid(accountNumber) || digitalBank.isAccountExisted(accountNumber)) && !accountNumber.equals("-1")) {
                    // 1 - Scenario 1/2: Invalid account number
                    if (!isAccountNumberValid(accountNumber)) {
                        System.out.println("Error: Invalid account number. Try again.");
                    }
                    // 1 - Scenario 2/2: Existed account number
                    else if (digitalBank.isAccountExisted(accountNumber)) {
                        System.out.println("Error: Existed account number. Try again.");
                    }
                    System.out.print("Enter new account number: ");
                    accountNumber = sc.nextLine().trim();
                }

                // Step 2/3: Ask for account balance
                double balance = 0;
                if (!accountNumber.equals("-1")) {

                    // 2 - Scenario 1/1: Invalid account balance
                    while (balance != -1 && !isAccountBalanceValid(balance)) {
                        try {
                            System.out.print("Enter balance for account " + accountNumber + ": ");
                            balance = sc.nextDouble();

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid account balance. Try again.");
                            sc.nextLine();
                        }

                        if (!isAccountBalanceValid(balance) && balance != 0 && balance != -1) {
                            System.out.println("Error: Invalid account balance. Try again.");
                            balance = 0;
                        }
                    }

                    // Step 3/3: Add account
                    if (balance != -1) {
                        // Add a saving account
                        if (choice == 2) {
                            SavingsAccount account = new SavingsAccount();
                            account.setAccountNumber(accountNumber);
                            account.setBalance(balance);
                            customer.addAccount(account);
                            account.getTransactions().add(new Transaction(accountNumber, balance, LocalDateTime.now(), Utils.getTransactionId(), false));
                            System.out.println("Successfully added account " + accountNumber + " for customer " + CUSTOMER_ID + ".");
                        }
                        // Add a loan account
                        else {
                            LoanAccount account = new LoanAccount();
                            account.setAccountNumber(accountNumber);
                            account.setBalance(balance);
                            customer.addAccount(account);
                            account.getTransactions().add(new Transaction(accountNumber, balance, LocalDateTime.now(), Utils.getTransactionId(), false));
                            System.out.println("Successfully added account " + accountNumber + " for customer " + CUSTOMER_ID + ".");
                        }

                    }
                }
            }

            /*** Function 4: Make a withdrawal ***/
            else if (choice == 4) {
                // Step 1/3: Ask for account number
                System.out.print("Enter account number: ");
                sc.nextLine();
                String accountNumber = sc.nextLine().trim();

                while ((!isAccountNumberValid(accountNumber) || !digitalBank.isAccountExisted(accountNumber)) && !accountNumber.equals("-1")) {
                    // 1 - Scenario 1/2: Invalid account number
                    if (!isAccountNumberValid(accountNumber)) {
                        System.out.println("Error: Invalid account number. Try again.");
                    }
                    // 1 - Scenario 2/2: Non-existent account number
                    else if (!digitalBank.isAccountExisted(accountNumber)) {
                        System.out.println("Error: Non-existent account number. Try again.");
                    }
                    System.out.print("Enter new account number: ");
                    accountNumber = sc.nextLine().trim();
                }

                // Step 2/3: Ask for withdrawal amount
                double amount = 0;
                if (!accountNumber.equals("-1")) {

                    // 2 - Scenario 1/1: Invalid withdrawal amount
                    while (amount != -1 && !isWithdrawalAmountValid(customer, accountNumber, amount)) {
                        try {
                            System.out.print("Enter withdrawal amount for account " + accountNumber + ": ");
                            amount = sc.nextDouble();

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid withdrawal amount. Try again.");
                            sc.nextLine();
                        }

                        if (amount != -1 && !isWithdrawalAmountValid(customer, accountNumber, amount)) {
                            System.out.println("Error: Invalid withdrawal amount. Try again.");
                            amount = 0;
                        }
                    }

                    // Step 3/3: Perform withdrawal
                    digitalBank.withdraw(CUSTOMER_ID, accountNumber, amount);
                }
            }

            /*** Function 5: Display transaction history ***/
            else if (choice == 5) {
                customer.displayTransactionHistory();
            }
        }

    }


    /*** CUSTOM FUNCTIONS ***/
    public static boolean isWithdrawalAmountValid(DigitalCustomer customer, String accountNumber, double amount) {
        if (customer.getAccountByAccountNumber(accountNumber) instanceof SavingsAccount) {
            return ((SavingsAccount) customer.getAccountByAccountNumber(accountNumber)).isAccepted(amount);

        }
        else if (customer.getAccountByAccountNumber(accountNumber) instanceof LoanAccount) {
            return ((LoanAccount) customer.getAccountByAccountNumber(accountNumber)).isAccepted(amount);
        }

        return false;
    }
}
