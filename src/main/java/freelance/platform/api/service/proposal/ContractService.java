package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.client.Company;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.proposal.Contract;
import freelance.platform.api.bean.proposal.Proposal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface ContractService {

    public Contract save(Contract contract);
    public Contract update(int id, Contract contract);

    public Optional<Contract> findByProposal(Proposal proposal);
    public Stream<Contract> findByCompany(Company company);
    public Stream<Contract> findByFreelancer(Freelancer freelancer);
    public Optional<Contract> findById(int id);
    public Page<Contract> findAll(Pageable pageable);

    public Contract delete(int id);

}
