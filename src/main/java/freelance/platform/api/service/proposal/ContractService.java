package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.proposal.Contract;
import freelance.platform.api.dto.proposal.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface ContractService {

    public ContractDto save(ContractDto dto);
    public ContractDto update(long id, ContractDto dto);

    public ContractDto findByProposal(long proposalId);
    public Stream<ContractDto> findByCompany(long companyId);
    public Stream<ContractDto> findByFreelancer(long freelancerId);
    public Optional<Contract> findById(long id);
    public ContractDto findByIdDto(long id);
    public Page<ContractDto> findAll(Pageable pageable);

    public void delete(long id);

}
