package kg.itschool.crmspring.respository;

import kg.itschool.crmspring.models.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long>{

}
