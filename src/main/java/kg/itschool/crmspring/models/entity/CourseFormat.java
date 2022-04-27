package kg.itschool.crmspring.models.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "course_format")
public class CourseFormat extends BaseEntity{




    @Column(name = "format" , nullable = false , length = 50)
    String format;

    @Column(name = "course_duration_weeks" , nullable = false)
    int courseDurationWeeks;

    @Column(name = "lesson_duration" , nullable = false )
    LocalTime lessonDuration;

    @Column(name = "lessons_per_week" , nullable = false)
    int lessonsPerWeek;

    @Column(name = "is_online" ,  nullable = false)
    boolean isOnline;
}
