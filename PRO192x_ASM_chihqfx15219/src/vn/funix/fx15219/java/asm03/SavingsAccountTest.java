package vn.funix.fx15219.java.asm03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SavingsAccountTest {

    private final SavingsAccount account = new SavingsAccount();
    private final double balance;
    private final double amount;
    private final boolean isTransactionSuccessful;

    public SavingsAccountTest(double balance, double amount, boolean isTransactionSuccessful) {
        this.balance = balance;
        this.amount = amount;
        this.isTransactionSuccessful = isTransactionSuccessful;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {7000000, 5550000, false},
                {7000000, 5000000, true},
                {10000000, 6000000, true},
                {2000000, 40000, false},
                {2000000, 1990000, false},
                {2000000, 99999, false},
                {2000000, 1500000, true}
        });
    }

    @Test
    public void withdraw() {
        account.setBalance(balance);
        assertEquals(isTransactionSuccessful, account.withdraw(amount));
    }

}