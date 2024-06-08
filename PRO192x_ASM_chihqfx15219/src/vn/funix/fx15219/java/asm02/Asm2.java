package vn.funix.fx15219.java.asm02;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Asm2 {

    /*** CONSTANTS ***/
    public static final HashMap<String, String> CITYCODE = new HashMap<>();
    public static final String author = "FX15219";
    public static final String version = "v2.0.0";
    public static final Bank bank = new Bank();

    // Add each city's name and its corresponding code to the HashMap
    static {
        CITYCODE.put("001", "Hà Nội");
        CITYCODE.put("002", "Hà Giang");
        CITYCODE.put("004", "Cao Bằng");
        CITYCODE.put("006", "Bắc Kạn");
        CITYCODE.put("008", "Tuyên Quang");
        CITYCODE.put("010", "Lào Cai");
        CITYCODE.put("011", "Điện Biên");
        CITYCODE.put("012", "Lai Châu");
        CITYCODE.put("014", "Sơn La");
        CITYCODE.put("015", "Yên Bái");
        CITYCODE.put("017", "Hòa Bình");
        CITYCODE.put("019", "Thái Nguyên");
        CITYCODE.put("020", "Lạng Sơn");
        CITYCODE.put("022", "Quảng Ninh");
        CITYCODE.put("024", "Bắc Giang");
        CITYCODE.put("025", "Phú Thọ");
        CITYCODE.put("026", "Vĩnh Phúc");
        CITYCODE.put("027", "Bắc Ninh");
        CITYCODE.put("030", "Hải Dương");
        CITYCODE.put("031", "Hải Phòng");
        CITYCODE.put("033", "Hưng Yên");
        CITYCODE.put("034", "Thái Bình");
        CITYCODE.put("035", "Hà Nam");
        CITYCODE.put("036", "Nam Định");
        CITYCODE.put("037", "Ninh Bình");
        CITYCODE.put("038", "Thanh Hóa");
        CITYCODE.put("040", "Nghệ An");
        CITYCODE.put("042", "Hà Tĩnh");
        CITYCODE.put("044", "Quảng Bình");
        CITYCODE.put("045", "Quảng Trị");
        CITYCODE.put("046", "Thừa Thiên Huế");
        CITYCODE.put("048", "Đà Nẵng");
        CITYCODE.put("049", "Quảng Nam");
        CITYCODE.put("051", "Quảng Ngãi");
        CITYCODE.put("052", "Bình Định");
        CITYCODE.put("054", "Phú Yên");
        CITYCODE.put("056", "Khánh Hòa");
        CITYCODE.put("058", "Ninh Thuận");
        CITYCODE.put("060", "Bình Thuận");
        CITYCODE.put("062", "Kon Tum");
        CITYCODE.put("064", "Gia Lai");
        CITYCODE.put("066", "Đắk Lắk");
        CITYCODE.put("067", "Đắk Nông");
        CITYCODE.put("068", "Lâm Đồng");
        CITYCODE.put("070", "Bình Phước");
        CITYCODE.put("072", "Tây Ninh");
        CITYCODE.put("074", "Bình Dương");
        CITYCODE.put("075", "Đồng Nai");
        CITYCODE.put("077", "Bà Rịa - Vũng Tàu");
        CITYCODE.put("079", "Hồ Chí Minh");
        CITYCODE.put("080", "Long An");
        CITYCODE.put("082", "Tiền Giang");
        CITYCODE.put("083", "Bến Tre");
        CITYCODE.put("084", "Trà Vinh");
        CITYCODE.put("086", "Vĩnh Long");
        CITYCODE.put("087", "Đồng Tháp");
        CITYCODE.put("089", "An Giang");
        CITYCODE.put("091", "Kiên Giang");
        CITYCODE.put("092", "Cần Thơ");
        CITYCODE.put("093", "Hậu Giang");
        CITYCODE.put("094", "Sóc Trăng");
        CITYCODE.put("095", "Bạc Liêu");
        CITYCODE.put("096", "Cà Mau");
    }

    /*** MAIN FUNCTION ***/
    public static void main(String[] args) {

        // Display the start-up menu
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGÂN HÀNG SỐ | " + author + "@" + version + "            |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("1. Thêm khách hàng");
        System.out.println("2. Thêm tài khoản cho khách hàng");
        System.out.println("3. Hiển thị danh sách khách hàng");
        System.out.println("4. Tìm khách hàng theo số CCCD");
        System.out.println("5. Tìm khách hàng theo tên");
        System.out.println("0. Thoát");
        System.out.println("Lưu ý: Nhập '-1' bất cứ khi nào muốn thoát khỏi quá trình thực hiện chức năng.");

        Scanner sc = new Scanner(System.in);

        // Create the variable that holds the choice of the user
        int choice = -1;

        // Run the program until choice is 0 (0 -> exit)
        while (choice != 0) {

            // Generate new choice & Handle invalid choice
            try {
                System.out.print("\nNhập lựa chọn chức năng: ");
                choice = sc.nextInt();
                if (choice < 0 || choice > 5) {
                    System.out.println("Lỗi: Lựa chọn không hợp lệ. Hãy thử lại.");
                    sc.nextLine();

                    // Reset choice
                    choice = -1;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Lỗi: Lựa chọn không hợp lệ. Hãy thử lại.");
                sc.nextLine();
            }

            // Function 1: Add a customer to the bank
            if (choice == 1) {
                // 1. Ask for customer ID
                System.out.print("Hãy nhập số CCCD của khách hàng mới: ");
                sc.nextLine();
                String cccd = sc.nextLine().trim();

                while ((!isCustomerIdValid(cccd) || bank.isCustomerExisted(cccd)) && !cccd.equals("-1")) {
                    // 1 - Scenario 1/2: Invalid customer ID
                    if (!isCustomerIdValid(cccd)) {
                        System.out.println("Lỗi: Số CCCD không hợp lệ. Hãy thử lại.");
                    }
                    // 1 - Scenario 2/2: Existed customer ID
                    else if (bank.isCustomerExisted(cccd)) {
                        System.out.println("Lỗi: Số CCCD đã tồn tại. Hãy thử lại.");
                    }
                    System.out.print("Hãy nhập số CCCD của khách hàng mới: ");
                    cccd = sc.nextLine().trim();
                }

                // 2. Ask for customer name
                if (!cccd.equals("-1")) {
                    System.out.print("Hãy nhập tên của khách hàng mới (gồm ít nhất 5 kí tự): ");
                    String name = sc.nextLine().trim();

                    // 2 - Scenario 1/1: Invalid customer name
                    while (!isCustomerNameValid(name) && !name.equals("-1")) {
                        System.out.println("Lỗi: Tên khách hàng không hợp lệ. Hãy thử lại.");
                        System.out.print("Hãy nhập tên của khách hàng mới (gồm ít nhất 5 kí tự): ");
                        name = sc.nextLine().trim();
                        if (name.equals("-1")) {
                            break;
                        }
                    }

                    // 3. Add the customer to the bank
                    if (!name.equals("-1")) {
                        Customer c = new Customer();
                        c.setCustomerName(formatCustomerName(name));
                        c.setCustomerId(cccd);
                        bank.addCustomer(c);
                        System.out.println("Đã thêm khách hàng " + cccd + " vào ngân hàng.");
                    }
                }

                // Reset choice
                choice = -1;
            }

            // Function 2: Add an account for a customer
            else if (choice == 2) {
                // 1. Ask for customer ID
                System.out.print("Hãy nhập số CCCD của khách hàng muốn thêm tài khoản: ");
                sc.nextLine();
                String cccd = sc.nextLine().trim();

                while ((!isCustomerIdValid(cccd) || !bank.isCustomerExisted(cccd)) && !cccd.equals("-1")) {
                    // 1 - Scenario 1/2: Invalid customer ID
                    if ((!isCustomerIdValid(cccd))) {
                        System.out.println("Lỗi: Số CCCD không hợp lệ. Hãy thử lại.");
                    }
                    // 1 - Scenario 2/2: Non-existent customer ID
                    else if (!bank.isCustomerExisted(cccd)) {
                        System.out.println("Lỗi: Số CCCD không tồn tại. Hãy thử lại.");
                    }
                    System.out.print("Hãy nhập số CCCD của khách hàng muốn thêm tài khoản: ");
                    cccd = sc.nextLine().trim();
                }

                // 2. Ask for account number
                if (!cccd.equals("-1")) {
                    System.out.print("Hãy nhập STK mới cho khách hàng " + cccd + ": ");
                    String accountNumber = sc.nextLine().trim();

                    while ((!isAccountNumberValid(accountNumber) || bank.isAccountExisted(accountNumber)) && !accountNumber.equals("-1")) {
                        // 2 - Scenario 1/2: Invalid account number
                        if (!isAccountNumberValid(accountNumber)) {
                            System.out.println("Lỗi: STK không hợp lệ. Hãy thử lại.");
                        }
                        // 2 - Scenario 2/2: Existed account number
                        else if (bank.isAccountExisted(accountNumber)) {
                            System.out.println("Lỗi: STK đã tồn tại. Hãy thử lại.");
                        }
                        System.out.print("Hãy nhập STK mới cho khách hàng " + cccd + ": ");
                        accountNumber = sc.nextLine().trim();
                    }

                    // 3. Ask for account balance
                    if (!accountNumber.equals("-1")) {
                        double balance = 0;

                        // 3 - Scenario 1/1: Invalid account balance
                        while (balance != -1 && !isAccountBalanceValid(balance)) {
                            try {
                                System.out.print("Hãy nhập số dư cho tài khoản " + accountNumber + ": ");
                                balance = sc.nextDouble();

                            } catch (InputMismatchException e) {
                                System.out.println("Lỗi: Số dư không hợp lệ. Hãy thử lại.");
                                sc.nextLine();
                            }

                            if (!isAccountBalanceValid(balance) && balance != 0 && balance != -1) {
                                System.out.println("Lỗi: Số dư không hợp lệ 2. Hãy thử lại.");
                                balance = 0;
                            }
                        }

                        // 4. Add customer account
                        if (balance != -1) {
                            Account account = new Account();
                            account.setAccountNumber(accountNumber);
                            account.setBalance(balance);
                            bank.addAccount(cccd, account);
                            System.out.println("Đã thêm tài khoản " + accountNumber + " cho khách hàng " + cccd + ".");
                        }
                    }
                }

                // Reset choice
                choice = -1;
            }

            // Function 3: Display the list of customers and their accounts
            else if (choice == 3) {
                if (!bank.getCustomers().isEmpty()) {
                    System.out.println("Danh sách khách hàng của ngân hàng: ");
                    for (Customer customer : bank.getCustomers()) {
                        customer.showCustomerInfo();
                    }
                }
                else {
                    System.out.println("Danh sách rỗng.");
                }

                // Reset choice
                choice = -1;
            }

            // Function 4: Find customer by CCCD
            else if (choice == 4) {
                // 1. Ask for customer ID
                System.out.print("Hãy nhập số CCCD của khách hàng muốn tìm: ");
                sc.nextLine();
                String cccd = sc.nextLine().trim();

                while ((!isCustomerIdValid(cccd) || !bank.isCustomerExisted(cccd)) && !cccd.equals("-1")) {
                    // 1 - Scenario 1/2: Invalid customer ID
                    if ((!isCustomerIdValid(cccd))) {
                        System.out.println("Lỗi: Số CCCD không hợp lệ. Hãy thử lại.");
                    }
                    // 1 - Scenario 2/2: Non-existent customer ID
                    else if (!bank.isCustomerExisted(cccd)) {
                        System.out.println("Lỗi: Số CCCD không tồn tại. Hãy thử lại.");
                    }
                    System.out.print("Hãy nhập số CCCD của khách hàng muốn thêm tài khoản: ");
                    cccd = sc.nextLine().trim();
                }

                // 2. Find by customer ID & Display the customer's information
                if (!cccd.equals("-1")) {
                    for (Customer customer : bank.getCustomers()) {
                        if (customer.getCustomerId().contains(cccd)) {
                            customer.showCustomerInfo();
                            System.out.println("Đã tìm thấy khách hàng.");
                        }
                    }
                }

                // Reset choice
                choice = -1;
            }

            // Function 5: Find customer by name
            else if (choice == 5) {
                boolean isExactNameFound = false;
                boolean isSimilarNameFound = false;
                boolean isCustomerFound = false;
                String name = " ";

                while (!isCustomerFound && !name.equals("-1")) {

                    // 1. Ask for customer name
                    System.out.print("Hãy nhập tên của khách hàng muốn tìm (gồm ít nhất 5 kí tự): ");
                    sc.nextLine();
                    name = sc.nextLine();

                    // 1 - Scenario 1/1: Too short name (generate too many results)
                    while (!isCustomerNameValid(name) && !name.equals("-1")) {
                        System.out.println("Lỗi: Tên khách hàng không hợp lệ. Hãy thử lại.");
                        System.out.print("Hãy nhập tên của khách hàng muốn tìm (gồm ít nhất 5 kí tự): ");
                        name = sc.nextLine();
                    }

                    // 2. Find by customer name & Display the customer's information
                    if (!name.equals("-1")) {
                        name = formatCustomerName(name);

                            // Find exact match
                            for (Customer customer : bank.getCustomers()) {
                                if (customer.getCustomerName().equals(name)) {
                                    customer.showCustomerInfo();
                                    System.out.println("Đã tìm thấy khách hàng.");
                                    isExactNameFound = true;
                                    break;
                                }
                            }

                            // 2 - Scenario 1/1: Exact match can't be found -> Find customers with similar names
                            if (!isExactNameFound) {
                                for (Customer customer : bank.getCustomers()) {
                                    if (customer.getCustomerName().contains(name)) {
                                        customer.showCustomerInfo();
                                        isSimilarNameFound = true;
                                    }
                                }

                                if (isSimilarNameFound) {
                                    System.out.println("Không tìm thấy khách hàng với tên chính xác. Đây là một số khách hàng với tên tương tự.");
                                }
                                else {
                                    System.out.println("Lỗi: Khách hàng với tên này không tồn tại. Hãy thử lại.");
                                }
                            }
                        }
                    isCustomerFound = isExactNameFound || isSimilarNameFound;
                }

                // Reset choice
                choice = -1;
            }

        }

    }

    /*** CUSTOM FUNCTION ***/

    // Function 1: Check if customer ID is valid
    public static boolean isCustomerIdValid(String customerId) {

        // Condition 1/3: Customer ID must contain 12 characters
        if (customerId.length() != 12) {
            return false;
        }

        // Condition 2/3: Customer ID must contain all digits
        for (int i = 0; i < 12; i++) {
            if (!Character.isDigit(customerId.charAt(i))) {
                return false;
            }
        }

        // Condition 3/3: Customer ID must have a legit city code
        String cityCode = customerId.substring(0, 3);
        boolean isCityCodeValid = false;
        for (String i : CITYCODE.keySet()) {
            if (cityCode.equals(i)) {
                isCityCodeValid = true;
                break;
            }
        }
        return isCityCodeValid;
    }

    // Function 2: Check if customer name is valid
    public static boolean isCustomerNameValid(String customerName) {

        // Condition 1/2: Customer name must contain only letters and white spaces
        for (int i = 0; i < customerName.length(); i++) {
            if (!Character.isLetter(customerName.charAt(i)) && !Character.isWhitespace(customerName.charAt(i))) {
                return false;
            }
        }

        // Condition 2/2: Customer name must contain at least 5 characters
        boolean isNameLengthValid = true;
        int letterCount = 0;
        for (int i = 0; i < customerName.length(); i++) {
            if (Character.isLetter(customerName.charAt(i))) {
                letterCount++;
            }
        }
        if (letterCount < 5) {
            isNameLengthValid = false;
        }
        return isNameLengthValid;
    }

    // Function 3: Format customer's name
    public static String formatCustomerName(String customerName) {
        // Delete unnecessary whitespaces
        customerName = customerName.trim();
        String[] words = customerName.split("\\s+");
        return String.join(" ", words);
    }

    // Function 4: Check if account number is valid
    public static boolean isAccountNumberValid(String accountNumber) {
        // Condition 1/2: Account number must contain 6 characters
        if (accountNumber.length() != 6) {
            return false;
        }

        // Condition 2/2: Account number must contain only digits
        for (int i = 0; i < accountNumber.length(); i++) {
            if (!Character.isDigit(accountNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Function 5: Check if account balance is valid
    public static boolean isAccountBalanceValid(double balance) {
        return balance >= 50000;
    }
}

