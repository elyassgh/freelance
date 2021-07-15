package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.freelancer.Certification;
import freelance.platform.api.bean.freelancer.Freelancer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface CertificationService {

    public Certification save(Certification certification);
    public Certification update(int id, Certification certification);

    public Stream<Certification> findByCertificationNameContains(String name);
    public Stream<Certification> findByCertificationProviderContains(String provider);
    public Stream<Certification> findByFreelancer(Freelancer freelancer);
    public Optional<Certification> findById(int id);
    public Page<Certification> findAll(Pageable pageable);

    public Certification delete (int id);

}
