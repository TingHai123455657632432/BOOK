package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author：邾头肉
 * @date：2024/3/8
 */
public class DateUtil {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static java.util.Date strToutilDate(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);

    }
    public static String utilDateToStr(Date date) {
        return dateFormat.format(date);
    }
    public static java.sql.Date utilDateTosqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }
    public static java.sql.Date strDateTosqlDate(String dateStr) throws ParseException {
        return utilDateTosqlDate(strToutilDate(dateStr));
    }
}
