package shop.mtcoding.buyer6.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String timeStampFormat(Timestamp timestamp) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        String resTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return resTime;
    }
}
