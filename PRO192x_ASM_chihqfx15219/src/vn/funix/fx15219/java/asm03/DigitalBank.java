package vn.funix.fx15219.java.asm03;

import vn.funix.fx15219.java.asm02.Bank;
import vn.funix.fx15219.java.asm02.Customer;

public class DigitalBank extends Bank {

    public boolean addCustomer(String customerId, String name) {
        if (!isCustomerExisted(customerId)) {
            DigitalCustomer customer = new DigitalCustomer();
            customer.setCustomerId(customerId);
            customer.setCustomerName(name);
            getCustomers().add(customer);
            return true;
        }
        return false;
    }

    public Customer getCustomerById(String customerId) {
        for (Customer customer : getCustomers()) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public boolean withdraw(String customerId, String accountNumber, double amount) {
        if (getCustomerById(customerId) != null) {
            ((DigitalCustomer) getCustomerById(customerId)).withdraw(accountNumber, amount);
            return true;
        }
        return false;
    }
}
