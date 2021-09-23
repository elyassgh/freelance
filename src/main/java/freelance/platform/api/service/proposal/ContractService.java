package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.client.Company;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.proposal.Contract;
import freelance.platform.api.bean.proposal.Proposal;
import freelance.platform.api.dto.proposal.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface ContractService {

    public ContractDto save(ContractDto contract);
    public ContractDto update(long id, ContractDto contract);

    public ContractDto findByProposal(long proposalId);
    public Stream<Contract> findByCompany(long companyId);
    public Stream<Contract> findByFreelancer(long freelancerId);
    public Optional<Contract> findById(long id);
    public ContractDto findByIdDto(long id);
    public Page<ContractDto> findAll(Pageable pageable);

    public void delete(long id);

}
