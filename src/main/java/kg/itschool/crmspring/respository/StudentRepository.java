package kg.itschool.crmspring.respository;

import kg.itschool.crmspring.models.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

    @Query(value = "select * from tb_student s where s.group_id = ?1", nativeQuery = true)
    List<Student> findAllByGroup_Id(Long id);
}
