package cn.njyazheng.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class Tools {
    public static final Hash163 USER_HASH = Hash163.newCustomHash(10);

    public  static  final String I_SUBSCRIBEINFO="I_SUBSCRIBEINFO";

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddHHmms = "yyyyMMddHHmmss";

    private static final ZoneId ZONE = ZoneId.systemDefault();

    public static String getUserHashTable(String talblePrefix,String user){
        return talblePrefix+USER_HASH.sHash(user);
    }
    public static Date getDateByFORMAT(String time, String format) {
        TemporalAccessor dt = DateTimeFormatter.ofPattern(format)
                .parseBest(time, LocalDateTime::from, LocalDate::from, LocalTime::from,
                        YearMonth::from, MonthDay::from, Year::from);
        if (dt instanceof LocalDateTime) {
            return Date.from(((LocalDateTime) dt).atZone(ZONE).toInstant());
        } else if (dt instanceof LocalDate) {
            return Date.from(((LocalDate) dt).atStartOfDay(ZONE).toInstant());

        } else if (dt instanceof LocalTime) {
            return Date.from(((LocalTime) dt).atDate(LocalDate.now()).atZone(ZONE).toInstant());
        } else if (dt instanceof YearMonth) {
            return Date.from(((YearMonth) dt).atDay(1).atStartOfDay(ZONE).toInstant());
        } else if (dt instanceof MonthDay) {
            return Date.from(((MonthDay) dt).atYear(LocalDate.now().getYear()).atStartOfDay(ZONE).toInstant());
        } else if (dt instanceof Year) {
            return Date.from(((Year) dt).atDay(1).atStartOfDay(ZONE).toInstant());
        } else {
            throw new RuntimeException("Unsupported Format :" + format);
        }
    }
}
