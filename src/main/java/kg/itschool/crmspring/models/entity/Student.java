package kg.itschool.crmspring.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student extends BaseEntity{

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

    Group group;
}
