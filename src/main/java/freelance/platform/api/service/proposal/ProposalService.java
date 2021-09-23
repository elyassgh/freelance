package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.job.Job;
import freelance.platform.api.bean.proposal.Proposal;
import freelance.platform.api.dto.proposal.ProposalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface ProposalService {

    public ProposalDto save(ProposalDto dto);
    public ProposalDto update(long id, ProposalDto dto);

    public Stream<ProposalDto> findByJob(long jobId);
    public Stream<ProposalDto> findByPaymentAmountBetween(Double minValue, Double maxValue);
    public Optional<Proposal> findById(long id);
    public ProposalDto findByIdDto(long id);
    public Page<ProposalDto> findAll(Pageable pageable);

    public void delete(long id);
}
