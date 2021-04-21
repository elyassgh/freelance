package freelance.platform.api.repository.proposal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.proposal.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

}
