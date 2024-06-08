package vn.funix.fx15219.java.asm02;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    private final Account account = new Account();
    @Test
    public void isPremiumAccount() {
        account.setBalance(10000000);
        assertTrue(account.isPremiumAccount());
        account.setBalance(9999999.999);
        assertFalse(account.isPremiumAccount());
    }
}