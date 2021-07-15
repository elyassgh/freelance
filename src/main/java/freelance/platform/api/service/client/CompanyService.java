package freelance.platform.api.service.client;

import freelance.platform.api.bean.client.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CompanyService {

    public Company save(Company company);
    public Company update(int id, Company company);

    public Optional<Company> findByName(String name);
    public Optional<Company> findById(int id);
    public Page<Company> findAll(Pageable pageable);

    public Company delete(int id);
}
