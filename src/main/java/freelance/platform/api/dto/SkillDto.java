package freelance.platform.api.dto;

import freelance.platform.api.bean.freelancer.Freelancer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {

    private String skillName;
    private List<Freelancer> freelancers;

}
