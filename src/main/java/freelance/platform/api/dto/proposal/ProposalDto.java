package freelance.platform.api.dto.proposal;

import freelance.platform.api.dto.PaymentTypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalDto {

    private Long id;
    private LocalDateTime proposalTime;
    private String clientGrade;
    private String clientComment;
    private String freelancerGrade;
    private String freelancerComment;
    private PaymentTypeDto paymentType;
    private Double paymentAmount;

}
