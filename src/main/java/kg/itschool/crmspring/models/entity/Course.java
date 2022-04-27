package kg.itschool.crmspring.models.entity;



import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends BaseEntity {


    @Column(name = "name" , nullable = false)
    String name;

    @Column(name = "price" , nullable = false)
    double price;


    @ManyToOne
    @JoinColumn(name = "course_format_id")
    CourseFormat courseFormat;
}
