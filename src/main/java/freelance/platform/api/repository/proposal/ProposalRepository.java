package freelance.platform.api.repository.proposal;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.proposal.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

}
