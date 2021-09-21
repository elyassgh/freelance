package freelance.platform.api.service.job;

import freelance.platform.api.bean.job.Duration;
import freelance.platform.api.dto.job.DurationDto;

import java.util.List;
import java.util.Optional;

public interface DurationService {

    public DurationDto save(DurationDto dto);
    public DurationDto update(long id, DurationDto dto);

    public Optional<Duration> findById(long id);
    public DurationDto findByIdDto(long id);
    public List<DurationDto> findAll();

    public void delete(long id);

}
