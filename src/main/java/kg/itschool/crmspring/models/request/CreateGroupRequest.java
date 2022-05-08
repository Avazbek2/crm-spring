package kg.itschool.crmspring.models.request;

import kg.itschool.crmspring.models.dto.CourseDto;
import kg.itschool.crmspring.models.dto.MentorDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateGroupRequest {

    String name;

    LocalTime groupTime;

    CourseDto course;

    MentorDto mentor;

    Boolean isActive;
}


