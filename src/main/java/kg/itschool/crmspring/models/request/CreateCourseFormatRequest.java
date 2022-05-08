package kg.itschool.crmspring.models.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCourseFormatRequest {

    String format;

    Integer courseDurationWeeks;

    @DateTimeFormat(pattern = "HH:mm")
    LocalTime lessonDuration;

    Integer lessonsPerWeek;

    Boolean isOnline;

    Boolean isActive;



}
