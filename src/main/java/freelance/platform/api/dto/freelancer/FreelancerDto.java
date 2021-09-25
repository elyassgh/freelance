package freelance.platform.api.dto.freelancer;

import freelance.platform.api.dto.SkillDto;
import freelance.platform.api.dto.UserAccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerDto {

    private Long id;
    private UserAccountDto account;
    private LocalDateTime registrationDate;
    private String location;
    private String bio;
    private List<SkillDto> skills;
    private List<CertificationDto> certifications;
    // private List<ContractDto> contracts;

}
