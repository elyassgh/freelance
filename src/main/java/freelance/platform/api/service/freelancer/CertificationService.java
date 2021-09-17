package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.freelancer.Certification;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.dto.freelancer.CertificationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface CertificationService {

    public CertificationDto save(CertificationDto dto);
    public CertificationDto update(long id, CertificationDto dto);

    public Stream<CertificationDto> findByCertificationNameContains(String name);
    public Stream<CertificationDto> findByCertificationProviderContains(String provider);
    public Stream<CertificationDto> findByFreelancer(long freelancerId);
    public Optional<Certification> findById(long id);
    public CertificationDto findByIdDto(long id);
    public Page<CertificationDto> findAll(Pageable pageable);

    public void delete (long id);

}
