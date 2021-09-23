package freelance.platform.api.serviceImpl.proposal;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.client.Company;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.proposal.Contract;
import freelance.platform.api.bean.proposal.Proposal;
import freelance.platform.api.converter.proposal.ContractConverter;
import freelance.platform.api.dto.proposal.ContractDto;
import freelance.platform.api.repository.proposal.ContractRepository;
import freelance.platform.api.service.PaymentTypeService;
import freelance.platform.api.service.client.CompanyService;
import freelance.platform.api.service.freelancer.FreelancerService;
import freelance.platform.api.service.proposal.ContractService;
import freelance.platform.api.service.proposal.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository repository;
    @Autowired
    ContractConverter converter;
    @Autowired
    CompanyService companyService;
    @Autowired
    PaymentTypeService paymentTypeService;
    @Autowired
    FreelancerService freelancerService;
    @Autowired
    ProposalService proposalService;

    @Override
    public ContractDto save(ContractDto dto) {
        Company company = companyService.findById(dto.getCompany().getId()).orElseThrow(() -> new RuntimeException("not found"));
        Freelancer freelancer = freelancerService.findById(dto.getFreelancer().getId()).orElseThrow(() -> new RuntimeException("not found"));
        Proposal proposal = proposalService.findById(dto.getProposal().getId()).orElseThrow(() -> new RuntimeException("not found"));
        Contract contract = converter.toEntity(dto);
        contract.setCompany(company);
        contract.setFreelancer(freelancer);
        contract.setProposal(proposal);
        return converter.toDto(repository.save(contract));
    }

    @Override
    public ContractDto update(long id, ContractDto dto) {
        Contract contract = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (dto.getFinishedAt() != null) contract.setFinishedAt(dto.getFinishedAt());
        if (dto.getPaymentAmount() != null) contract.setPaymentAmount(dto.getPaymentAmount());
        if (dto.getPaymentType() != null) {
            PaymentType paymentType = paymentTypeService.findById(dto.getPaymentType().getId())
                    .orElseThrow(() -> new RuntimeException("not found"));
            contract.setPaymentType(paymentType);
        }
        return converter.toDto(repository.save(contract));
    }

    @Override
    public ContractDto findByProposal(long proposalId) {
        Proposal proposal = proposalService.findById(proposalId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(repository.findByProposal(proposal));
    }

    @Override
    public Stream<ContractDto> findByCompany(long companyId) {
        Company company = companyService.findById(companyId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findByCompany(company));
    }

    @Override
    public Stream<ContractDto> findByFreelancer(long freelancerId) {
        Freelancer freelancer = freelancerService.findById(freelancerId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findByFreelancer(freelancer));
    }

    @Override
    public Optional<Contract> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public ContractDto findByIdDto(long id) {
        Contract contract = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(contract);
    }

    @Override
    public Page<ContractDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Contract contract = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(contract);
    }
}
