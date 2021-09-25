package freelance.platform.api.repository.proposal;

import freelance.platform.api.bean.job.Job;
import freelance.platform.api.bean.proposal.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    Stream<Proposal> findByJob(Job job);
    Stream<Proposal> findByPaymentAmountBetween(Double minValue, Double maxValue);

}
