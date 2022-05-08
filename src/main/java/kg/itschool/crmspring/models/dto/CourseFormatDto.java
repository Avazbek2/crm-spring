package kg.itschool.crmspring.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseFormatDto implements Serializable {
     Long id;

     String format;
     Integer courseDurationWeeks;
     LocalTime lessonDuration;
     Integer lessonsPerWeek;
     Boolean isOnline;
     Boolean isActive;
}
