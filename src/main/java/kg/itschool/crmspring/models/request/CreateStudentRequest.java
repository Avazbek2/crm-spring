package kg.itschool.crmspring.models.request;

import kg.itschool.crmspring.models.dto.GroupDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateStudentRequest {

    String firstName;

    String lastName;

    String phoneNumber;

    String email;

    LocalDate dob;

    GroupDto group;
}


