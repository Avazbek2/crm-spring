package kg.itschool.crmspring.respository;

import kg.itschool.crmspring.models.entity.CourseFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseFormatRepository extends JpaRepository<CourseFormat , Long> {
}
