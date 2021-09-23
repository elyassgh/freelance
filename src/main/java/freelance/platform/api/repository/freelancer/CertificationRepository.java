package freelance.platform.api.repository.freelancer;

import freelance.platform.api.bean.freelancer.Certification;
import freelance.platform.api.bean.freelancer.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
    Stream<Certification> findByCertificationNameContains(String name);
    Stream<Certification> findByCertificationProviderContains(String provider);
    Stream<Certification> findByFreelancer(Freelancer freelancer);
}
