package freelance.platform.api.serviceImpl.proposal;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.job.Job;
import freelance.platform.api.bean.proposal.Proposal;
import freelance.platform.api.converter.proposal.ProposalConverter;
import freelance.platform.api.dto.proposal.ProposalDto;
import freelance.platform.api.repository.proposal.ProposalRepository;
import freelance.platform.api.service.PaymentTypeService;
import freelance.platform.api.service.job.JobService;
import freelance.platform.api.service.proposal.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    ProposalRepository repository;
    @Autowired
    ProposalConverter converter;
    @Autowired
    JobService jobService;
    @Autowired
    PaymentTypeService paymentTypeService;

    @Override
    public ProposalDto save(long jobId, ProposalDto dto) {
        Job job = jobService.findById(jobId).orElseThrow(() -> new RuntimeException("not found"));
        PaymentType paymentType = paymentTypeService.findById(dto.getPaymentType().getId()).orElseThrow(() -> new RuntimeException("not found"));
        Proposal proposal = converter.toEntity(dto);
        proposal.setJob(job);
        proposal.setPaymentType(paymentType);
        return converter.toDto(repository.save(proposal));
    }

    @Override
    public ProposalDto update(long id, ProposalDto dto) {
        Proposal proposal = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (dto.getClientComment() != null) proposal.setClientComment(dto.getClientComment());
        if (dto.getClientGrade() != null) proposal.setClientGrade(dto.getClientGrade());
        if (dto.getFreelancerComment() != null) proposal.setFreelancerComment(dto.getFreelancerComment());
        if (dto.getFreelancerGrade() != null) proposal.setFreelancerGrade(dto.getFreelancerGrade());
        if (dto.getPaymentType() != null) {
            PaymentType paymentType = paymentTypeService.findById(dto.getPaymentType().getId())
                    .orElseThrow(() -> new RuntimeException("not found"));
            proposal.setPaymentType(paymentType);
        }
        return converter.toDto(repository.save(proposal));
    }

    @Override
    public Stream<ProposalDto> findByJob(long jobId) {
        Job job = jobService.findById(jobId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findByJob(job));
    }

    @Override
    public Stream<ProposalDto> findByPaymentAmountBetween(Double minValue, Double maxValue) {
        return converter.toDtosStream(repository.findByPaymentAmountBetween(minValue, maxValue));
    }

    @Override
    public Optional<Proposal> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public ProposalDto findByIdDto(long id) {
        Proposal proposal = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(proposal);
    }

    @Override
    public Page<ProposalDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Proposal proposal = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(proposal);
    }
}
