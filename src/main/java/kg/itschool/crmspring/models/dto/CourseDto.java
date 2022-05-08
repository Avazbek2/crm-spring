package kg.itschool.crmspring.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDto implements Serializable {
     Long id;

     String name;
     Double price;
     CourseFormatDto courseFormat;
     Boolean isActive;
}
