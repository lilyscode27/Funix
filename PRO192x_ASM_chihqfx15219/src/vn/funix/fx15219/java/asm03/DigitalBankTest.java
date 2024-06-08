package vn.funix.fx15219.java.asm03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitalBankTest {

    private final DigitalBank bank = new DigitalBank();

    @Test
    public void getCustomerById() {
        bank.addCustomer("011111111111", "John Doe");
        assertEquals("011111111111", bank.getCustomerById("011111111111").getCustomerId());
        assertEquals("John Doe", bank.getCustomerById("011111111111").getCustomerName());
    }


}