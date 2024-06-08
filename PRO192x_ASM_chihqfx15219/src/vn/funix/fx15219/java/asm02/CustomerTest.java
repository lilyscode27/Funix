package vn.funix.fx15219.java.asm02;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private static Customer customer1;
    private static Customer customer2;

    @BeforeClass
    public static void setUp() {
        customer1 = new Customer();
        customer1.setCustomerId("012345678900");
        customer1.setCustomerName("John Doe");
        Account account1 = new Account();
        account1.setAccountNumber("000001");
        account1.setBalance(100000);
        customer1.addAccount(account1);
        Account account2 = new Account();
        account2.setAccountNumber("000002");
        account2.setBalance(50000);
        customer1.addAccount(account2);

        customer2 = new Customer();
        customer2.setCustomerId("011111111111");
        customer2.setCustomerName("Jane Doe");
        Account account3 = new Account();
        account3.setAccountNumber("000003");
        account3.setBalance(10000000);
        customer2.addAccount(account3);
        Account account4 = new Account();
        account4.setAccountNumber("000004");
        account4.setBalance(3000000);
        customer2.addAccount(account4);
    }

    @Test
    public void isPremiumCustomer() {
        assertFalse(customer1.isPremiumCustomer());
        assertTrue(customer2.isPremiumCustomer());

    }

    @Test
    public void getTotalBalance() {
        assertEquals(150000, customer1.getTotalBalance(), 0.0000001);
        assertEquals(13000000, customer2.getTotalBalance(), 0.0000001);
    }
}