package vn.funix.fx15219.java.asm02;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private static Bank bank;

    @BeforeClass
    public static void setUp() {
        bank = new Bank();
        Customer customer1 = new Customer();
        customer1.setCustomerId("012345678900");
        customer1.setCustomerName("John Doe");
        bank.addCustomer(customer1);
        Account account1 = new Account();
        account1.setAccountNumber("000001");
        account1.setBalance(100000);
        bank.addAccount("012345678900", account1);

        Customer customer2 = new Customer();
        customer2.setCustomerId("012345678901");
        customer2.setCustomerName("Jane Doe");
        bank.addCustomer(customer2);
        Account account2 = new Account();
        account2.setAccountNumber("000002");
        account2.setBalance(500000);
        bank.addAccount("012345678901", account2);
        Account account3 = new Account();
        account3.setAccountNumber("000003");
        account3.setBalance(1000000);
        bank.addAccount("012345678901", account3);
    }

    @Test
    public void isCustomerExisted() {
        assertFalse(bank.isCustomerExisted("011111111111"));
        assertTrue(bank.isCustomerExisted("012345678900"));
        assertTrue(bank.isCustomerExisted("012345678901"));
    }

    @Test
    public void isAccountExisted() {
        assertFalse(bank.isAccountExisted("111111"));
        assertTrue(bank.isAccountExisted("000001"));
        assertTrue(bank.isAccountExisted("000002"));
        assertTrue(bank.isAccountExisted("000003"));
    }
}