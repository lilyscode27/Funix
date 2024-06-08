package vn.funix.fx15219.java.asm02;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final String bankId; // Randomly generated
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.bankId = String.valueOf(UUID.randomUUID());
    }

    public String getBankId() {
        return bankId;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean isCustomerExisted(String customerId) {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    public void addCustomer(Customer c) {
        if (!isCustomerExisted(c.getCustomerId())) {
            customers.add(c);
        }
    }

    public boolean isAccountExisted(String accountNumber) {
        for (Customer customer : this.getCustomers()) {
            for (Account account : customer.getAccounts()) {
                if (accountNumber.equals(account.getAccountNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addAccount(String cccd, Account account) {
        for (Customer customer : this.getCustomers()) {
            if (customer.getCustomerId().equals(cccd)) {
                customer.addAccount(account);
            }
        }
    }

}
