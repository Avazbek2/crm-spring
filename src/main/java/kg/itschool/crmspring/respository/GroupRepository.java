package kg.itschool.crmspring.respository;

import kg.itschool.crmspring.models.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group , Long> {
}
