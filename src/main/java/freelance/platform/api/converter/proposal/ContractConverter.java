package freelance.platform.api.converter.proposal;

import freelance.platform.api.bean.proposal.Contract;
import freelance.platform.api.converter.PaymentTypeConverter;
import freelance.platform.api.converter.client.CompanyConverter;
import freelance.platform.api.converter.freelancer.FreelancerConverter;
import freelance.platform.api.dto.proposal.ContractDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ContractConverter {

    @Autowired
    PaymentTypeConverter paymentTypeConverter;
    @Autowired
    FreelancerConverter freelancerConverter;
    @Autowired
    CompanyConverter companyConverter;
    @Autowired
    ProposalConverter proposalConverter;

    public Contract toEntity(ContractDto dto) {
        return Contract.builder().id(dto.getId())
                .paymentAmount(dto.getPaymentAmount())
                .build();
    }

    public List<Contract> toEntities(List<ContractDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public ContractDto toDto(Contract contract) {
        return ContractDto.builder().id(contract.getId())
                .paymentAmount(contract.getPaymentAmount())
                .paymentType(paymentTypeConverter.toDto(contract.getPaymentType()))
                .freelancer(freelancerConverter.toDto(contract.getFreelancer()))
                .company(companyConverter.toDto(contract.getCompany()))
                .proposal(proposalConverter.toDto(contract.getProposal()))
                .issuedAt(contract.getIssuedAt())
                .finishedAt(contract.getFinishedAt())
                .build();
    }

    public List<ContractDto> toDtos(List<Contract> contracts) {
        return contracts.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<ContractDto> toDtosPage(Page<Contract> contractsPage) {
        return contractsPage.map(this::toDto);
    }

    public Stream<ContractDto> toDtosStream(Stream<Contract> contractsStream) {
        return contractsStream.map(this::toDto);
    }

}
