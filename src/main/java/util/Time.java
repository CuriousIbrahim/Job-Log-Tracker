package util;

import java.time.LocalDate;
import java.time.ZoneId;

public class Time {

    public static long localDateToUnixTimestamp(LocalDate date) {
        return date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
    }

}
