package vn.funix.fx15219.java.asm02;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Asm2Test {

    @Test
    public void isCustomerIdValid() {
        // Condition 1/3: Customer ID must contain 12 characters
        assertFalse(Asm2.isCustomerIdValid("012345"));

        // Condition 2/3: Customer ID must contain all digits
        assertFalse(Asm2.isCustomerIdValid("01234567890a"));

        // Condition 3/3: Customer ID must have a legit city code
        assertFalse(Asm2.isCustomerIdValid("000123456789"));

        assertTrue(Asm2.isCustomerIdValid("012345678900"));
    }

    @Test
    public void isAccountNumberValid() {
        // Condition 1/2: Account number must contain 6 characters
        assertFalse(Asm2.isAccountNumberValid("12345"));

        // Condition 2/2: Account number must contain only digits
        assertFalse(Asm2.isAccountNumberValid("12345a"));

        assertTrue(Asm2.isAccountNumberValid("123456"));
    }
}