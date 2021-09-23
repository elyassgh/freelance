package freelance.platform.api.dto.job;

import freelance.platform.api.dto.PaymentTypeDto;
import freelance.platform.api.dto.SkillDto;
import freelance.platform.api.dto.client.ManagerDto;
import freelance.platform.api.dto.proposal.ProposalDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {

    private Long id;
    private String description;
    private ManagerDto manager;
    private ComplexityDto complexity;
    private DurationDto duration;
    private PaymentTypeDto paymentType;
    private Double paymentAmount;
    private SkillDto skill;
    private List<SkillDto> otherSkills;
    private List<ProposalDto> proposals;

}
