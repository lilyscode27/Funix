package vn.funix.fx15219.java.asm03;

import vn.funix.fx15219.java.asm02.Account;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LoanAccount extends Account implements Withdraw, Report {
    public static final double LOAN_ACCOUNT_WITHDRAWAL_FEE_PREMIUM = 0.01;
    public static final double LOAN_ACCOUNT_WITHDRAWAL_FEE_NORMAL = 0.05;
    public static final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public boolean isAccepted(double amount) {
        return (amount <= LOAN_ACCOUNT_MAX_BALANCE && amount > 0) && // Condition 1/2: Credit limit must not exceed 100000k.
                (getBalance() - amount - getTransactionFee(amount) >= 50000); // Condition 2/2: Balance must be equal to or larger than 50k after withdrawal.
    }

    public double getTransactionFee(double amount) {
        if (isPremiumAccount()) {
            return amount * LOAN_ACCOUNT_WITHDRAWAL_FEE_PREMIUM;
        }
        return amount * LOAN_ACCOUNT_WITHDRAWAL_FEE_NORMAL;
    }

    @Override
    public boolean withdraw(double amount) {
        if (isAccepted(amount)) {
            setBalance(getBalance() - amount - getTransactionFee(amount));
            transactions.add(new Transaction(getAccountNumber(), getBalance(), LocalDateTime.now(), Utils.getTransactionId(), true));
            log(amount);
            return true;
        }
        return false;
    }

    public void log(double amount) {
        Utils.getDivider();
        System.out.printf("%40s%n", "TRANSACTION RECEIPT FOR LOAN ACCOUNT");
        System.out.printf("Date:%39s%n", Utils.formatDateTime(LocalDateTime.now()));
        System.out.printf("ATM ID: %36s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("Account number: %28s%n", getAccountNumber());
        System.out.printf("Amount: %36s%n", Utils.formatBalance(amount));
        System.out.printf("Balance: %35s%n", Utils.formatBalance(getBalance()));
        System.out.printf("Transaction fee: %27s%n", Utils.formatBalance(getTransactionFee(amount)));
        Utils.getDivider();
    }

    @Override
    public void showAccountInfo() {
        System.out.print(getAccountNumber() + " | ");
        DecimalFormat formatter = new DecimalFormat("#,###.###");
        String balanceOutput = formatter.format(getBalance()) + "đ";
        for (int i = 0; i < 20 - "LOANS".length(); i++) {
            System.out.print(" ");
        }
        System.out.print("LOANS" + " |");
        for (int i = 0; i < 34 - balanceOutput.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(balanceOutput);
        System.out.println();
    }
}
