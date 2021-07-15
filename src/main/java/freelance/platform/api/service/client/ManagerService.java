package freelance.platform.api.service.client;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.client.Company;
import freelance.platform.api.bean.client.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface ManagerService {

    public Manager save(Manager manager);
    public Manager update(int id, Manager manager);

    public Stream<Manager> findByCompany(Company company);
    public Stream<Manager> findByLocation(String Location);
    public Manager findByAccount(UserAccount userAccount);
    public Optional<Manager> findById(int id);
    public Page<Manager> findAll(Pageable pageable);

    public Manager delete(int id);
}
