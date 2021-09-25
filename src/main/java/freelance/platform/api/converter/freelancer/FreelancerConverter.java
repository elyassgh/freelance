package freelance.platform.api.converter.freelancer;

import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.converter.SkillConverter;
import freelance.platform.api.converter.UserAccountConverter;
import freelance.platform.api.dto.freelancer.FreelancerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FreelancerConverter {

    @Autowired
    UserAccountConverter userAccountConverter;
    @Autowired
    SkillConverter skillConverter;
    @Autowired
    CertificationConverter certificationConverter;

    public Freelancer toEntity(FreelancerDto dto) {
        return Freelancer.builder().id(dto.getId())
                .bio(dto.getBio())
                .location(dto.getLocation())
                .build();
    }

    public List<Freelancer> toEntities(List<FreelancerDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public FreelancerDto toDto(Freelancer freelancer) {
        return FreelancerDto.builder().id(freelancer.getId())
                .account(userAccountConverter.toDto(freelancer.getAccount()))
                .location(freelancer.getLocation())
                .bio(freelancer.getBio())
                .registrationDate(freelancer.getRegistrationDate())
                .skills(skillConverter.toDtos(freelancer.getSkills()))
                .certifications(certificationConverter.toDtos(freelancer.getCertifications()))
                //.contracts(contractConverter.toDtos(freelancer.getContracts()))
                .build();
    }

    public List<FreelancerDto> toDtos(List<Freelancer> freelancers) {
        return freelancers.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<FreelancerDto> toDtosPage(Page<Freelancer> freelancersPage) {
        return freelancersPage.map(this::toDto);
    }

    public Stream<FreelancerDto> toDtosStream(Stream<Freelancer> freelancersStream) {
        return freelancersStream.map(this::toDto);
    }

}
