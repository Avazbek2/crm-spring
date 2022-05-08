package kg.itschool.crmspring.models.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_course_format")
public class CourseFormat{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    Long id;



    @Column(name = "format" , nullable = false , length = 50)
    String format;

    @Column(name = "course_duration_weeks" , nullable = false)
    Integer courseDurationWeeks;

    @Column(name = "lesson_duration" , nullable = false )
    LocalTime lessonDuration;

    @Column(name = "lessons_per_week" , nullable = false)
    Integer lessonsPerWeek;

    @Column(name = "is_online" ,  nullable = false)
    Boolean isOnline;

    @Column(name =  "is_Active" , nullable = false)
    Boolean isActive;
}
