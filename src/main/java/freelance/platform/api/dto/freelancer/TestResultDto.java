package freelance.platform.api.dto.freelancer;

import freelance.platform.api.bean.freelancer.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResultDto {

    private Long id;
    private FreelancerDto freelancer;
    private Test test;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String testResultLink;
    private Double score;
    private Boolean displayOnProfile;

}
