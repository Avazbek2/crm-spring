package kg.itschool.crmspring.models.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    Long id;

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

    @Column(name =  "is_Active" , nullable = false)
    Boolean isActive;




    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    Group group;


}
