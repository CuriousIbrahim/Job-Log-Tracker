package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Time {

    public static long localDateToUnixTimestamp(LocalDate date) {
        return date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
    }

    // Answer from Holger on https://stackoverflow.com/questions/35183146/how-can-i-create-a-java-8-localdate-from-a-long-epoch-time-in-milliseconds
    public static LocalDate unixTimestampToLocalDate(int timestamp){
        return Instant.ofEpochMilli((long) timestamp * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
