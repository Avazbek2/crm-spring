package kg.itschool.crmspring.models.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@Setter
@Getter
@ToString
@Entity
@Table(name = "group")
public class Group extends BaseEntity{

    @Column(name = "name" , nullable = false , length = 50)
    String name;

    @Column(name = "group_time")
    LocalTime groupTime;


    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;


    @ManyToOne
    @JoinColumn(name = "mentor_id")
    Mentor mentor;
}
