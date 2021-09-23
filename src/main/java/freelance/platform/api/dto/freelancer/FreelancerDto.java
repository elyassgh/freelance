package freelance.platform.api.dto.freelancer;

import freelance.platform.api.bean.proposal.Contract;
import freelance.platform.api.dto.SkillDto;
import freelance.platform.api.dto.UserAccountDto;
import freelance.platform.api.dto.proposal.ContractDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerDto {

    private Long id;
    private UserAccountDto account;
    private LocalDate registrationDate;
    private String location;
    private String bio;
    private List<CertificationDto> certifications;
    private List<SkillDto> skills;
    private List<ContractDto> contracts;

}
