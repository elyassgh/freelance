package freelance.platform.api.repository.proposal;

import freelance.platform.api.bean.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.proposal.Proposal;

import java.util.stream.Stream;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    Stream<Proposal> findByJob(Job job);
    Stream<Proposal> findByPaymentAmountBetween(Double minValue, Double maxValue);
}
