package freelance.platform.api.repository.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.freelancer.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

}
