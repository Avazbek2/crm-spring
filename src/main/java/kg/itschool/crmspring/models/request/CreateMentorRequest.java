package kg.itschool.crmspring.models.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateMentorRequest {

    String firstName;

    String lastName;

    String phoneNumber;

    String email;

    LocalDate dob;

    Double salary;

}

