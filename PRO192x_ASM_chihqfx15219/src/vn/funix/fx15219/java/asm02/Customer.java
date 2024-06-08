package vn.funix.fx15219.java.asm02;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremiumCustomer() {
        for (Account account : getAccounts()) {
            if (account.isPremiumAccount()) {
                return true;
            }
        }
        return false;
    }

    public boolean isAccountExisted(String accountNumber) {
        for (Account a : accounts) {
            if (accountNumber.equals(a.getAccountNumber())) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(Account newAccount) {
        if (!isAccountExisted(newAccount.getAccountNumber())) {
            accounts.add(newAccount);
        }
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (Account a : accounts) {
            totalBalance += a.getBalance();
        }
        return totalBalance;
    }

    public void showCustomerInfo() {
        System.out.print(this.getCustomerId() + " | ");
        for (int i = 0; i < 20 - this.getCustomerName().length(); i++) {
            System.out.print(" ");
        }
        System.out.print(this.getCustomerName() + " | ");
        if (this.isPremiumCustomer()) {
            System.out.print("   Premium | ");
        } else {
            System.out.print("    Normal | ");
        }

        DecimalFormat formatter = new DecimalFormat("#,###.###");
        String totalBalanceOutput = formatter.format(this.getTotalBalance()) + "đ";
        for (int i = 0; i < 20 - totalBalanceOutput.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(totalBalanceOutput);
        System.out.println();

        int i = 1;
        for (Account account : this.getAccounts()) {
            System.out.print(i);
            for (int j = 0; j < 6 - String.valueOf(i).length(); j++) {
                System.out.print(" ");
            }
            account.showAccountInfo();
            i++;
        }
    }

}
