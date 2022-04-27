package kg.itschool.crmspring.models.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    Long id;

    @Column(name = "date_created" , nullable = false , updatable = false , columnDefinition = "TIMESTAMP DEFAULT NOW()")
    LocalDateTime dateCreated;


    @Column(name = "date_update" )
    LocalDate dateUpdate;

}
