package vn.funix.fx15219.java.asm02;

import static vn.funix.fx15219.java.asm02.Asm2.CITYCODE;

public class User {
    String customerName;
    String customerId;

    public User() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        boolean isCustomerIdLengthValid = true;
        boolean isCustomerIdAllDigits = true;
        boolean isCityCodeValid = false;

        // Condition 1/3: Customer ID must contain 12 characters
        if (customerId.length() != 12) {
            isCustomerIdLengthValid = false;
        }

        // Condition 2/3: Customer ID must contain all digits
        for (int i = 0; i < 12; i++) {
            if (!Character.isDigit(customerId.charAt(i))) {
                isCustomerIdAllDigits = false;
            }
        }

        // Condition 3/3: Customer ID must have a legit city code
        String cityCode = customerId.substring(0, 3);
        for (String i : CITYCODE.keySet()) {
            if (cityCode.equals(i)) {
                isCityCodeValid = true;
                break;
            }
        }
        
        // Set customer ID if all conditions are correct
        if (isCustomerIdLengthValid && isCustomerIdAllDigits && isCityCodeValid) {
            this.customerId = customerId;
        }
}


}
