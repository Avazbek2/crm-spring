package kg.itschool.crmspring.models.dto;

import kg.itschool.crmspring.models.dto.CourseDto;
import kg.itschool.crmspring.models.dto.MentorDto;
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
public class GroupDto implements Serializable {
     Long id;

     String name;
     LocalTime groupTime;
     CourseDto course;
     MentorDto mentor;
     Boolean isActive;
}
