package kg.itschool.crmspring.models.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Entity
@Table(name = "mentor")
public class Mentor extends BaseEntity{

    @Column(name = "first_name" , nullable = false , length = 50)
    String firstName;

    @Column(name = "last_name" , nullable = false , length = 50)
    String lastName;

    @Column(name = "phone_number" , nullable = false , length = 13)
    String phoneNumber;

    @Column(name = "email" , nullable = false , length = 100)
    String email;

    @Column(name = "dob" , nullable = false )
    LocalDate dob;

    @Column(name = "salary" , nullable = false)
    Double salary;


}

