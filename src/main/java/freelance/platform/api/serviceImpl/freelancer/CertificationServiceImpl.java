package freelance.platform.api.serviceImpl.freelancer;

import freelance.platform.api.bean.freelancer.Certification;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.converter.freelancer.CertificationConverter;
import freelance.platform.api.dto.freelancer.CertificationDto;
import freelance.platform.api.repository.freelancer.CertificationRepository;
import freelance.platform.api.service.freelancer.CertificationService;
import freelance.platform.api.service.freelancer.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CertificationServiceImpl implements CertificationService {

    @Autowired
    CertificationRepository repository;
    @Autowired
    CertificationConverter converter;
    @Autowired
    FreelancerService freelancerService;

    @Override
    public CertificationDto save(CertificationDto dto) {
        Freelancer freelancer = freelancerService.findById(dto.getFreelancer().getId()).orElseThrow(()-> new RuntimeException("not found"));
        Certification certification = converter.toEntity(dto);
        certification.setFreelancer(freelancer);
        return converter.toDto(repository.save(certification));
    }

    @Override
    public CertificationDto update(long id, CertificationDto dto) {
        Certification certification = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (dto.getCertificationLink() != null) certification.setCertificationLink(dto.getCertificationLink());
        if (dto.getCertificationName() != null) certification.setCertificationName(dto.getCertificationName());
        if (dto.getCertificationProvider() != null)
            certification.setCertificationProvider(dto.getCertificationProvider());
        if (dto.getDateEarned() != null) certification.setDateEarned(dto.getDateEarned());
        if (dto.getDescription() != null) certification.setDescription(dto.getDescription());
        return converter.toDto(repository.save(certification));
    }

    @Override
    public Stream<CertificationDto> findByCertificationNameContains(String name) {
        return converter.toDtosStream(repository.findByCertificationNameContains(name));
    }

    @Override
    public Stream<CertificationDto> findByCertificationProviderContains(String provider) {
        return converter.toDtosStream(repository.findByCertificationNameContains(provider));
    }

    @Override
    public Stream<CertificationDto> findByFreelancer(long freelancerId) {
        Freelancer freelancer = freelancerService.findById(freelancerId).orElseThrow(()-> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findByFreelancer(freelancer));
    }

    @Override
    public Optional<Certification> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public CertificationDto findByIdDto(long id) {
        Certification certification = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(certification);
    }

    @Override
    public Page<CertificationDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Certification certification = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(certification);
    }
}
