package models;

import enums.CalendarType;
import enums.Subject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Calendar {
    private Subject subject;
    private String location;
    private String date;
    private String time;
    private String secondDate;
    private String secondTime;
    private CalendarType calendarType;
    private String description;
    private String name;
    private String relatedTo;

}
