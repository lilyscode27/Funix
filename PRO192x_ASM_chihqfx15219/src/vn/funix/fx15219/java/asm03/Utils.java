package vn.funix.fx15219.java.asm03;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Utils {
    public static void getDivider() {
        System.out.println("+----------+--------------------+----------+");
    }

    /*public static String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }*/

    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }

    public static String formatBalance(double balance) {
        DecimalFormat formatter = new DecimalFormat("#,###.###");
        return formatter.format(balance) + "đ";
    }

    public static String getTransactionId() {
        return String.valueOf(UUID.randomUUID());
    }

}
