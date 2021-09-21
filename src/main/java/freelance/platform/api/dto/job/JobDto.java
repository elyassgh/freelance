package freelance.platform.api.dto.job;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.job.Complexity;
import freelance.platform.api.bean.job.Duration;
import freelance.platform.api.bean.proposal.Proposal;
import freelance.platform.api.dto.PaymentTypeDto;
import freelance.platform.api.dto.SkillDto;
import freelance.platform.api.dto.client.ManagerDto;
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
    // dont forget to change it dto
    private List<Proposal> proposals;

}
