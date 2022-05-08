package kg.itschool.crmspring.models.entity;



import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    Long id;

    @Column(name = "name" , nullable = false)
    String name;

    @Column(name = "price" , nullable = false)
    Double price;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_format_id")
    CourseFormat courseFormat;

    @Column(name =  "is_Active" , nullable = false)
    Boolean isActive;
}
