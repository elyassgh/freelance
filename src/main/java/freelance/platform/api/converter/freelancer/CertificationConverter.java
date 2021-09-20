package freelance.platform.api.converter.freelancer;

import freelance.platform.api.bean.freelancer.Certification;
import freelance.platform.api.dto.freelancer.CertificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CertificationConverter {

    @Autowired
    FreelancerConverter freelancerConverter;

    public Certification toEntity(CertificationDto dto) {
        return Certification.builder().id(dto.getId())
                .certificationLink(dto.getCertificationLink())
                .certificationName(dto.getCertificationName())
                .certificationProvider(dto.getCertificationProvider())
                .description(dto.getDescription())
                .dateEarned(dto.getDateEarned())
                .build();
    }

    public List<Certification> toEntities(List<CertificationDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public CertificationDto toDto(Certification certification) {
        return CertificationDto.builder().id(certification.getId())
                .certificationLink(certification.getCertificationLink())
                .certificationName(certification.getCertificationName())
                .certificationProvider(certification.getCertificationProvider())
                .description(certification.getDescription())
                .dateEarned(certification.getDateEarned())
                .freelancer(freelancerConverter.toDto(certification.getFreelancer()))
                .build();
    }

    public List<CertificationDto> toDtos(List<Certification> certifications) {
        return certifications.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<CertificationDto> toDtosPage(Page<Certification> certificationsPage) {
        return certificationsPage.map(this::toDto);
    }

    public Stream<CertificationDto> toDtosStream(Stream<Certification> certificationsStream) {
        return certificationsStream.map(this::toDto);
    }

}
