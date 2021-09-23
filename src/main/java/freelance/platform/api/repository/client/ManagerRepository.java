package freelance.platform.api.repository.client;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.client.Company;
import freelance.platform.api.bean.client.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Stream<Manager> findByCompany(Company company);
    Stream<Manager> findByLocationContains(String Location);
    Manager findByAccount(UserAccount userAccount);

}
