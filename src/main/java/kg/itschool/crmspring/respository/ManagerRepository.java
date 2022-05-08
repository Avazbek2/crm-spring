package kg.itschool.crmspring.respository;

import kg.itschool.crmspring.models.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
