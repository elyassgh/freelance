package freelance.platform.api.repository.proposal;

import freelance.platform.api.bean.client.Company;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.proposal.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.proposal.Contract;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    Optional<Contract> findByProposal(Proposal proposal);
    Stream<Contract> findByCompany(Company company);
    Stream<Contract> findByFreelancer(Freelancer freelancer);
}
