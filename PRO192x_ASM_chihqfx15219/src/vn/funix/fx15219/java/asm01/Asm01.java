package vn.funix.fx15219.java.asm01;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Asm01 {
    /*** HẰNG ***/

    // HashMap mã thành phố/tỉnh và tên tương ứng
    static final HashMap<String, String> MATHANHPHO = new HashMap<>();

    // Tên tác giả và phiên bản
    static final String AUTHOR = "FX15219";
    static final String VERSION = "1.0.0";


    /*** HÀM CHÍNH ***/
    public static void main(String[] args) {

        // Gán mã thành phố/tỉnh và tên tương ứng cho HashMap MATHANHPHO
        MATHANHPHO.put("001", "Hà Nội");
        MATHANHPHO.put("002", "Hà Giang");
        MATHANHPHO.put("004", "Cao Bằng");
        MATHANHPHO.put("006", "Bắc Kạn");
        MATHANHPHO.put("008", "Tuyên Quang");
        MATHANHPHO.put("010", "Lào Cai");
        MATHANHPHO.put("011", "Điện Biên");
        MATHANHPHO.put("012", "Lai Châu");
        MATHANHPHO.put("014", "Sơn La");
        MATHANHPHO.put("015", "Yên Bái");
        MATHANHPHO.put("017", "Hòa Bình");
        MATHANHPHO.put("019", "Thái Nguyên");
        MATHANHPHO.put("020", "Lạng Sơn");
        MATHANHPHO.put("022", "Quảng Ninh");
        MATHANHPHO.put("024", "Bắc Giang");
        MATHANHPHO.put("025", "Phú Thọ");
        MATHANHPHO.put("026", "Vĩnh Phúc");
        MATHANHPHO.put("027", "Bắc Ninh");
        MATHANHPHO.put("030", "Hải Dương");
        MATHANHPHO.put("031", "Hải Phòng");
        MATHANHPHO.put("033", "Hưng Yên");
        MATHANHPHO.put("034", "Thái Bình");
        MATHANHPHO.put("035", "Hà Nam");
        MATHANHPHO.put("036", "Nam Định");
        MATHANHPHO.put("037", "Ninh Bình");
        MATHANHPHO.put("038", "Thanh Hóa");
        MATHANHPHO.put("040", "Nghệ An");
        MATHANHPHO.put("042", "Hà Tĩnh");
        MATHANHPHO.put("044", "Quảng Bình");
        MATHANHPHO.put("045", "Quảng Trị");
        MATHANHPHO.put("046", "Thừa Thiên Huế");
        MATHANHPHO.put("048", "Đà Nẵng");
        MATHANHPHO.put("049", "Quảng Nam");
        MATHANHPHO.put("051", "Quảng Ngãi");
        MATHANHPHO.put("052", "Bình Định");
        MATHANHPHO.put("054", "Phú Yên");
        MATHANHPHO.put("056", "Khánh Hòa");
        MATHANHPHO.put("058", "Ninh Thuận");
        MATHANHPHO.put("060", "Bình Thuận");
        MATHANHPHO.put("062", "Kon Tum");
        MATHANHPHO.put("064", "Gia Lai");
        MATHANHPHO.put("066", "Đắk Lắk");
        MATHANHPHO.put("067", "Đắk Nông");
        MATHANHPHO.put("068", "Lâm Đồng");
        MATHANHPHO.put("070", "Bình Phước");
        MATHANHPHO.put("072", "Tây Ninh");
        MATHANHPHO.put("074", "Bình Dương");
        MATHANHPHO.put("075", "Đồng Nai");
        MATHANHPHO.put("077", "Bà Rịa - Vũng Tàu");
        MATHANHPHO.put("079", "Hồ Chí Minh");
        MATHANHPHO.put("080", "Long An");
        MATHANHPHO.put("082", "Tiền Giang");
        MATHANHPHO.put("083", "Bến Tre");
        MATHANHPHO.put("084", "Trà Vinh");
        MATHANHPHO.put("086", "Vĩnh Long");
        MATHANHPHO.put("087", "Đồng Tháp");
        MATHANHPHO.put("089", "An Giang");
        MATHANHPHO.put("091", "Kiên Giang");
        MATHANHPHO.put("092", "Cần Thơ");
        MATHANHPHO.put("093", "Hậu Giang");
        MATHANHPHO.put("094", "Sóc Trăng");
        MATHANHPHO.put("095", "Bạc Liêu");
        MATHANHPHO.put("096", "Cà Mau");

        // Hiển thị menu mở đầu
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGÂN HÀNG SỐ | " + AUTHOR + "@v" + VERSION + "            |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| 1. Nhập CCCD                             |");
        System.out.println("| 0. Thoát                                 |");
        System.out.println("+----------+--------------------+----------+");

        // Mở scanner để lấy input từ người dùng
        Scanner sc = new Scanner(System.in);

        // Yêu cầu nhập lựa chọn menu mở đầu. Yêu cầu nhập lại nếu lựa chọn không hợp lệ.
        boolean validChoice = false;
        byte choice = -1;
        do {
            try {
                System.out.print("\nHãy nhập lựa chọn chức năng: ");
                choice = sc.nextByte();

                if (choice == 0 || choice == 1) {
                    validChoice = true;
                }
                else {
                    System.out.println("Lựa chọn không hợp lệ. Hãy thử lại.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy thử lại.");
                sc.nextLine();
            }
        } while (!validChoice);

        // Trường hợp: Lựa chọn là 1 - Nhập CCCD
        if (choice == 1) {

            // 1. Yêu cầu nhập lựa chọn chế độ kiểm tra mã xác thực. Yêu cầu nhập lại nếu lựa chọn không hợp lệ.
            boolean validChoice1 = false;
            byte choice1 = -1;
            do {
                try {
                    System.out.print("\nHãy nhập lựa chọn kiểm tra mã xác thực ở chế độ DỄ (1) hoặc KHÓ (2): ");
                    choice1 = sc.nextByte();
                    if (choice1 == 1 || choice1 == 2) {
                        validChoice1 = true;
                    }
                    else {
                        System.out.println("Lựa chọn không hợp lệ. Hãy thử lại.");
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Lựa chọn không hợp lệ. Hãy thử lại.");
                    sc.nextLine();
                }
            } while (!validChoice1);

            // 2. Yêu cầu nhập và kiểm tra mã xác thực theo chế độ tương ứng. Yêu cầu nhập lại nếu mã xác thực không hợp lệ.
            if (choice1 == 1) {
                KTmaXacThuc_de(sc);
            }
            else {
                KTmaXacThuc_kho(sc);
            }

            // 3. Yêu cầu nhập CCCD. Yêu cầu nhập lại nếu CCCD không hợp lệ
            System.out.print("\nNhập CCCD: ");
            String cccd = sc.next();
            while (!KTcccd(cccd)) {
                System.out.println("Hãy thử lại.");
                System.out.print("Nhập CCCD: ");
                cccd = sc.next();
            }

            // 4. Hiển thị menu chức năng sau khi đã nhập CCCD hợp lệ
            System.out.println();
            System.out.println("| 1. Kiểm tra nơi sinh");
            System.out.println("| 2. Kiểm tra năm sinh, giới tính");
            System.out.println("| 3. Kiểm tra số ngẫu nhiên");
            System.out.println("| 0. Thoát");

            byte choice2 = -1;
            while (choice2 != 0) {
                // 5. Yêu cầu nhập lựa chọn menu chức năng. Yêu cầu nhập lại nếu lựa chọn không hợp lệ.
                choice2 = -1;
                boolean validChoice2 = false;
                do {
                    try {
                        System.out.print("\nHãy nhập lựa chọn chức năng: ");
                        choice2 = sc.nextByte();
                        if (choice2 == 0 || choice2 == 1 || choice2 == 2 || choice2 == 3) {
                            validChoice2 = true;
                        }
                        else {
                            System.out.println("Lựa chọn không hợp lệ. Hãy thử lại.");
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Lựa chọn không hợp lệ. Hãy thử lại.");
                        sc.nextLine();
                    }
                } while (!validChoice2);

                // Trường hợp 5.1: Lựa chọn là 1 - Hiển thị nơi sinh
                if (choice2 == 1) {
                    System.out.println("Nơi sinh: " + noiSinh(cccd));
                }

                // Trường hợp 5.2: Lựa chọn là 2 - Hiển thị năm sinh & giới tính
                else if (choice2 == 2) {
                    System.out.println("Giới tính: " + gioiTinh(cccd));
                    System.out.println("Năm sinh: " + namSinh(cccd));

                }

                // Trường hợp 5.3: Lựa chọn là 3 - Hiển thị số ngẫu nhiên
                else if (choice2 == 3) {
                    System.out.println("Số ngẫu nhiên: " + soNgauNhien(cccd));
                }
            }
        }

        sc.close();
    }


    /*** HÀM CHỨC NĂNG ***/

    // Hàm 1.a: Yêu cầu nhập và kiểm tra mã xác thực ở chế độ DỄ. Yêu cầu nhập lại nếu mã xác thực không hợp lệ.
    public static void KTmaXacThuc_de(Scanner sc) {
        // 1. Khởi tạo mã xác thực là số nguyên ngẫu nhiên từ 0 - 999
        Random random = new Random();
        int maXacThuc = random.nextInt(1000);

        // 2. Yêu cầu nhập lại mã xác thực đến khi nào hợp lệ
        System.out.print("Mã xác thực của bạn là " + maXacThuc + ". ");
        boolean validInput = false;
        int user_maXacThuc;
        do {
            try {
                System.out.print("Hãy nhập lại mã xác thực: ");
                user_maXacThuc = sc.nextInt();
                if (maXacThuc == user_maXacThuc) {
                    validInput = true;
                }
                else {
                    System.out.println("Mã xác thực không đúng. Hãy thử lại.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Mã xác thực không đúng. Hãy thử lại.");
                sc.nextLine();
            }
        } while (!validInput);
    }

    // Hàm 1.b: Yêu cầu nhập và kiểm tra mã xác thực ở chế độ KHÓ. Yêu cầu nhập lại nếu mã xác thực không hợp lệ.
    public static void KTmaXacThuc_kho(Scanner sc) {
        // 1. Khởi tạo mã xác thực là chuỗi ngẫu nhiên gồm 6 kí tự cả chữ và số sử dụng StringBuilder

        // 1.1. Khai báo StringBuilder 'randomValue'
        Random random = new Random();
        StringBuilder randomValue = new StringBuilder();

        // 1.2. Khai báo 3 chuỗi chứa các kí tự viết hoa, các kí tự viết thường và các kí tự số
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // 1.3. Thêm vào 'randomValue' 1 kí tự viết hoa, 1 kí tự viết thường và 1 kí tự số ngẫu nhiên ==> Được 3/6 kí tự
        randomValue.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        randomValue.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        randomValue.append(numbers.charAt(random.nextInt(numbers.length())));

        // 1.4. Thêm vào 'randomValue' 3 kí tự ngẫu nhiên còn lại ==> Được 6/6 kí tự
        for (int i = 0; i < 3; i++) {
            String characters = upperCaseLetters + lowerCaseLetters + numbers;
            randomValue.append(characters.charAt(random.nextInt(characters.length())));
        }

        // 1.5. Tráo vị trí các kí tự trong 'randomValue'
        for (int i = randomValue.length() - 1; i >= 0; i--) {
            char temp = randomValue.charAt(i);
            int j = random.nextInt(i + 1);
            randomValue.setCharAt(i, randomValue.charAt(j));
            randomValue.setCharAt(j, temp);
        }

        // 1.6. Chuyển đổi 'randomValue' thành kiểu String
        String maXacThuc = randomValue.toString();

        // 2. Yêu cầu nhập lại mã xác thực  đến khi nào hợp lệ
        System.out.print("Mã xác thực của bạn là " + maXacThuc + ". Hãy nhập lại mã xác thực: ");
        String user_maXacThuc = sc.next();
        while (!maXacThuc.equals(user_maXacThuc)) {
            System.out.println("Mã xác thực không đúng. Hãy thử lại.");
            System.out.print("Hãy nhập lại mã xác thực: ");
            user_maXacThuc = sc.next();
        }
    }

    // Hàm 2: Kiểm tra CCCD hợp lệ
    public static boolean KTcccd(String cccd) {

        // 1. Kiểm tra điều kiện 1: CCCD phải gồm 12 kí tự
        if (cccd.length() != 12) {
            System.out.print("CCCD phải gồm 12 kí tự. ");
            return false;
        }

        // 2. Kiểm tra điều kiện 2: CCCD phải gồm các kí tự là chữ số
        for (int i = 0; i < 12; i++) {
            if (!Character.isDigit(cccd.charAt(i))) {
                System.out.print("CCCD phải gồm các kí tự là chữ số. ");
                return false;
            }
        }

        // 3. Kiểm tra điều kiện 3: CCCD phải có mã thành phố/tỉnh hợp lệ

        // 3.1. Tách chuỗi cccd lấy chuỗi chứa mã thành phố/tỉnh
        String maThanhPho = cccd.substring(0, 3);
        boolean checkCityCode = false;
        // Tìm mã thành phố/tỉnh trong HashMap MATHANHPHO
        for (String i : MATHANHPHO.keySet()) {
            if (maThanhPho.equals(i)) {
                checkCityCode = true;
                break;
            }
        }
        // 3.2. In thông báo nếu mã thành phố/tỉnh không hợp lệ
        if (!checkCityCode) {
            System.out.print("CCCD phải có mã thành phố/tỉnh hợp lệ. ");
        }
        return checkCityCode;
    }

    // Hàm 3: Trả về tên nơi sinh
    public static String noiSinh(String cccd) {
        // 1. Tách chuỗi cccd lấy chuỗi chứa mã thành phố/tỉnh
        String maThanhPho = cccd.substring(0, 3);

        // 2. Trả về tên thành phố/tỉnh tương ứng theo HashMap MATHANHPHO
        return MATHANHPHO.get(maThanhPho);
    }

    // Hàm 4: Trả về tên giới tính
    public static String gioiTinh(String cccd) {
        // 1. Lấy kí tự thể hiện giới tính trong chuỗi cccd và chuyển thành kiểu số nguyên
        int gioiTinh = cccd.charAt(3) - '0';

        // 2. Trả về tên giới tính tương ứng (nam có số thể hiện giới tính là chẵn, nữ là lẻ)
        if (gioiTinh % 2 == 0) {
            return "nam";
        }
        else {
            return "nữ";
        }
    }

    // Hàm 5: Trả về năm sinh
    public static int namSinh(String cccd) {
        // 1. Lấy kí tự thể hiện giới tính trong chuỗi cccd
        char gioiTinh = cccd.charAt(3);

        // 2. Xác định thế kỉ năm sinh dựa vào kí tự thể hiện giới tính
        int theKi;
        if (gioiTinh == '0' || gioiTinh == '1') {
            theKi = 20;
        }
        else if (gioiTinh == '2' || gioiTinh == '3') {
            theKi = 21;
        }
        else if (gioiTinh == '4' || gioiTinh == '5') {
            theKi = 22;
        }
        else if (gioiTinh == '6' || gioiTinh == '7') {
            theKi = 23;
        }
        else {
            theKi = 24;
        }

        // 3. Tách chuỗi cccd lấy chuỗi chứa năm sinh và chuyển thành kiểu số nguyên
        int namSinh = Integer.parseInt(cccd.substring(4, 6));

        // 4. Trả về năm sinh tương ứng
        return (theKi - 1)*100 + namSinh;
    }

    // Hàm 6: Trả về số ngẫu nhiên
    public static String soNgauNhien(String cccd) {
        // Tách chuỗi cccd lấy chuỗi chứa số ngẫu nhiên
        return cccd.substring(6);
    }
}
