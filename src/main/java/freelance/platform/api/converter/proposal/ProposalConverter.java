package freelance.platform.api.converter.proposal;

import freelance.platform.api.bean.proposal.Proposal;
import freelance.platform.api.converter.PaymentTypeConverter;
import freelance.platform.api.dto.proposal.ProposalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProposalConverter {

    @Autowired
    PaymentTypeConverter paymentTypeConverter;

    public Proposal toEntity(ProposalDto dto) {
        return Proposal.builder().id(dto.getId())
                .paymentAmount(dto.getPaymentAmount())
                .build();
    }

    public List<Proposal> toEntities(List<ProposalDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public ProposalDto toDto(Proposal proposal) {
        return ProposalDto.builder().id(proposal.getId())
                .proposalTime(proposal.getProposalTime())
                .paymentAmount(proposal.getPaymentAmount())
                .paymentType(paymentTypeConverter.toDto(proposal.getPaymentType()))
                .clientComment(proposal.getClientComment())
                .clientGrade(proposal.getClientGrade())
                .freelancerComment(proposal.getFreelancerComment())
                .freelancerGrade(proposal.getFreelancerGrade())
                .build();
    }

    public List<ProposalDto> toDtos(List<Proposal> proposals) {
        return proposals.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<ProposalDto> toDtosPage(Page<Proposal> proposalsPage) {
        return proposalsPage.map(this::toDto);
    }

    public Stream<ProposalDto> toDtosStream(Stream<Proposal> proposalsStream) {
        return proposalsStream.map(this::toDto);
    }
}
