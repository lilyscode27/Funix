package vn.funix.fx15219.java.asm02;

import java.text.DecimalFormat;

public class Account {
    String accountNumber;
    double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        boolean isAccountNumberLengthValid = true;
        boolean isAccountNumberAllDigits = true;

        // Condition 1/2: Account number must contain 6 characters
        if (accountNumber.length() != 6) {
            isAccountNumberLengthValid = false;
        }

        // Condition 2/2: Account number must contain only digits
        for (int i = 0; i < accountNumber.length(); i++) {
            if (!Character.isDigit(accountNumber.charAt(i))) {
                isAccountNumberAllDigits = false;
            }
        }

        if (isAccountNumberLengthValid && isAccountNumberAllDigits) {
            this.accountNumber = accountNumber;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 50000) {
            this.balance = balance;
        }
    }

    public boolean isPremiumAccount() {
        return this.balance >= 10000000;
    }

    public void showAccountInfo() {
        System.out.print(getAccountNumber() + " | ");
        DecimalFormat formatter = new DecimalFormat("#,###.###");
        String balanceOutput = formatter.format(this.getBalance()) + "đ";
        for (int i = 0; i < 56 - balanceOutput.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(balanceOutput);
        System.out.println();

    }
}
