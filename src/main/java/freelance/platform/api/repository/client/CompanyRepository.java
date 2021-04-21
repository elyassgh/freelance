package freelance.platform.api.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.client.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
