package freelance.platform.api.repository.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.client.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    List<Manager> findByCompany();

    List<Manager> findByLocation();

}
