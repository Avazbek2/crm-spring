package kg.itschool.crmspring.models.request;

import kg.itschool.crmspring.models.dto.CourseFormatDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCourseRequest {

    String name;

    Double price;

    CourseFormatDto courseFormat;

    Boolean isActive;


}
