package freelance.platform.api.service.job;

import freelance.platform.api.bean.job.Job;
import freelance.platform.api.dto.job.JobDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface JobService {

    public JobDto save(JobDto dto);
    public JobDto update(long id, JobDto dto);

    public Stream<JobDto> findByManager(long managerId);
    public Page<JobDto> findBySkill(long skillId, Pageable pageable);
    public Page<JobDto> findByPaymentAmountIsGreaterThanEqual(Double minValue, Pageable pageable);
    public Optional<Job> findById(long id);
    public JobDto findByIdDto(long id);
    public Page<JobDto> findAll(Pageable pageable);

    public void delete(long id);

}
