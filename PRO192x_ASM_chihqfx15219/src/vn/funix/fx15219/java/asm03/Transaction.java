package vn.funix.fx15219.java.asm03;

import java.time.LocalDateTime;

public class Transaction {
    private final String accountNumber;
    private final double amount;
    private final LocalDateTime dateTime;
    private final String transactionId;
    private final boolean isWithdrawal;

    public boolean isWithdrawal() {
        return isWithdrawal;
    }

    public Transaction(String accountNumber, double amount, LocalDateTime dateAndTime, String transactionId, boolean isWithdrawal) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.dateTime = dateAndTime;
        this.transactionId = transactionId;
        this.isWithdrawal = isWithdrawal;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void displayTransaction() {
        System.out.printf("%7s |", getAccountNumber());
        if (isWithdrawal()) {
            System.out.printf("%20s |", "-".concat(Utils.formatBalance(getAmount())));
        }
        else {
            System.out.printf("%20s |", "+".concat(Utils.formatBalance(getAmount())));
        }
        System.out.printf("%25s |", Utils.formatDateTime(getDateTime()));
        System.out.printf("%39s%n", getTransactionId());
    }
}
