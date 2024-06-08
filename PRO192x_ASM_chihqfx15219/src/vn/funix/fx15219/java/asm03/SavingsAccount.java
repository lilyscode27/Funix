package vn.funix.fx15219.java.asm03;

import vn.funix.fx15219.java.asm02.Account;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SavingsAccount extends Account implements Withdraw, Report {
    public static final double SAVINGS_ACCOUNT_MIN_WITHDRAWAL = 50000;
    public static final double SAVINGS_ACCOUNT_MAX_WITHDRAWAL_NORMAL = 5000000;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public boolean isAccepted(double amount) {
        // Condition 1/4: For non-premium account, withdrawal amount must not exceed 5000k.
        if (!isPremiumAccount() && amount > SAVINGS_ACCOUNT_MAX_WITHDRAWAL_NORMAL) {
            return false;
        }

        return (amount >= SAVINGS_ACCOUNT_MIN_WITHDRAWAL) && // Condition 2/4: Withdrawal amount must be at least 50k.
                (getBalance() - amount >= 50000) && // Condition 3/4: Balance must be equal to or larger than 50k after withdrawal.
                (amount % 10000 == 0); // Condition 4/4: Withdrawal amount must be a multiple of 10k.
    }

    @Override
    public boolean withdraw(double amount) {
        if (isAccepted(amount)) {
            setBalance(getBalance() - amount);
            transactions.add(new Transaction(getAccountNumber(), getBalance(), LocalDateTime.now(), Utils.getTransactionId(), true));
            log(amount);
            return true;
        }
        return false;
    }

    @Override
    public void log(double amount) {
        Utils.getDivider();
        System.out.printf("%42s%n", "TRANSACTION RECEIPT FOR SAVINGS ACCOUNT");
        System.out.printf("Date:%39s%n", Utils.formatDateTime(LocalDateTime.now()));
        System.out.printf("ATM ID: %36s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("Account number: %28s%n", getAccountNumber());
        System.out.printf("Amount: %36s%n", Utils.formatBalance(amount));
        System.out.printf("Balance: %35s%n", Utils.formatBalance(getBalance()));
        System.out.printf("Transaction fee: %27s%n", Utils.formatBalance(0));
        Utils.getDivider();
    }

    @Override
    public void showAccountInfo() {
        System.out.print(getAccountNumber() + " | ");
        DecimalFormat formatter = new DecimalFormat("#,###.###");
        String balanceOutput = formatter.format(getBalance()) + "đ";
        for (int i = 0; i < 20 - "SAVINGS".length(); i++) {
            System.out.print(" ");
        }
        System.out.print("SAVINGS" + " |");
        for (int i = 0; i < 34 - balanceOutput.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(balanceOutput);
        System.out.println();
    }
}
