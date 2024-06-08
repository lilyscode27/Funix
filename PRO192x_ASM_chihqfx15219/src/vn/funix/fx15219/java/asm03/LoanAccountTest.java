package vn.funix.fx15219.java.asm03;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanAccountTest {
    private final LoanAccount account = new LoanAccount();

    @Test
    public void getTransactionFee() {
        // Withdrawal fee for non-premium account is 0.05
        account.setBalance(5000000);
        assertEquals(300000 * 0.05, account.getTransactionFee(300000));
        // Withdrawal fee for premium account is 0.01
        account.setBalance(10000000);
        assertEquals(300000 * 0.01, account.getTransactionFee(300000));
    }

    @Test
    public void withdraw() {
        // Condition 1/2: Credit limit must not exceed 100000k.
        account.setBalance(200000000);
        assertFalse(account.withdraw(100000001));
        assertTrue(account.withdraw(100000000));

        // Condition 2/2: Balance must be equal to or larger than 50k after withdrawal.
        account.setBalance(100000);
        assertFalse(account.withdraw(50000));
        assertTrue(account.withdraw(30000));
    }
}