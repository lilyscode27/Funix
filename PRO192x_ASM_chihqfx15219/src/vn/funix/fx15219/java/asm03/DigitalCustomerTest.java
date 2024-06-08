package vn.funix.fx15219.java.asm03;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DigitalCustomerTest {

    @Test
    public void getAccountByAccountNumber() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber("000001");
        LoanAccount loanAccount = new LoanAccount();
        loanAccount.setAccountNumber("000002");

        DigitalCustomer customer = new DigitalCustomer();
        customer.addAccount(savingsAccount);
        customer.addAccount(loanAccount);

        assertEquals(savingsAccount, customer.getAccountByAccountNumber("000001"));
        assertEquals(loanAccount, customer.getAccountByAccountNumber("000002"));
        assertNull(customer.getAccountByAccountNumber("000003"));
    }
}