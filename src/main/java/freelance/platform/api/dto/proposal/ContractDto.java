package freelance.platform.api.dto.proposal;

import freelance.platform.api.dto.PaymentTypeDto;
import freelance.platform.api.dto.client.CompanyDto;
import freelance.platform.api.dto.freelancer.FreelancerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {

    private Long id;
    private ProposalDto proposal;
    private CompanyDto company;
    private FreelancerDto freelancer;
    private PaymentTypeDto paymentType;
    private Double paymentAmount;
    private LocalDateTime issuedAt;
    private LocalDateTime finishedAt;

}
