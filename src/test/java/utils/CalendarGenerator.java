package utils;

import enums.CalendarType;
import enums.Subject;
import models.Calendar;

public class CalendarGenerator {

    public Calendar getCalendarData() {

        Calendar calendar = Calendar.builder()
                .subject(Subject.MEETING)
                .location("KJH")
                .calendarType(CalendarType.CALL)
                .description("ytuutti")
                .build();
        return calendar;
    }
}
