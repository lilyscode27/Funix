package vn.funix.fx15219.java.asm03;

import vn.funix.fx15219.java.asm02.Account;
import vn.funix.fx15219.java.asm02.Customer;

import java.util.ArrayList;
import java.util.Comparator;

public class DigitalCustomer extends Customer {

    public boolean withdraw(String accountNumber, double amount) {

        if (getAccountByAccountNumber(accountNumber) instanceof SavingsAccount) {
            return ((SavingsAccount) getAccountByAccountNumber(accountNumber)).withdraw(amount);
        }
        else if (getAccountByAccountNumber(accountNumber) instanceof LoanAccount) {
            return ((LoanAccount) getAccountByAccountNumber(accountNumber)).withdraw(amount);
        }

        return false;
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        for (Account account : getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayTransactionHistory() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        for (Account acc : getAccounts()) {
            if (acc instanceof LoanAccount) {
                transactions.addAll(((LoanAccount) acc).getTransactions());
            }
            else if (acc instanceof  SavingsAccount) {
                transactions.addAll(((SavingsAccount) acc).getTransactions());
            }
        }

        transactions.sort(Comparator.comparing(Transaction::getDateTime));

        System.out.printf("%7s |", "Account");
        System.out.printf("%20s |", "Amount");
        System.out.printf("%25s |", "Time");
        System.out.printf("%39s%n", "Transaction ID");
        for (Transaction transaction : transactions) {
            transaction.displayTransaction();
        }
    }

}
