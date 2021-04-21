package freelance.platform.api.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.client.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
