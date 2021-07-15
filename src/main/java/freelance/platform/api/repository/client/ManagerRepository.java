package freelance.platform.api.repository.client;

import java.util.stream.Stream;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.client.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.client.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Stream<Manager> findByCompany(Company company);
    Stream<Manager> findByLocation(String Location);
    Manager findByAccount(UserAccount userAccount);

}
