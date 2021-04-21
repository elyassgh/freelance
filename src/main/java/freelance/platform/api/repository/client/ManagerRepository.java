package freelance.platform.api.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.client.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
