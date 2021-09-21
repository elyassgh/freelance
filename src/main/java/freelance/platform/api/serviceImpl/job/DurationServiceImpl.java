package freelance.platform.api.serviceImpl.job;

import freelance.platform.api.bean.job.Duration;
import freelance.platform.api.converter.job.DurationConverter;
import freelance.platform.api.dto.job.DurationDto;
import freelance.platform.api.repository.job.DurationRepository;
import freelance.platform.api.service.job.DurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DurationServiceImpl implements DurationService {

    @Autowired
    DurationRepository repository;
    @Autowired
    DurationConverter converter;

    @Override
    public DurationDto save(DurationDto dto) {
        Duration duration = converter.toEntity(dto);
        return converter.toDto(repository.save(duration));
    }

    @Override
    public DurationDto update(long id, DurationDto dto) {
        Duration duration = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(repository.save(duration));
    }

    @Override
    public Optional<Duration> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public DurationDto findByIdDto(long id) {
        Duration duration = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(duration);
    }

    @Override
    public List<DurationDto> findAll() {
        return converter.toDtos(repository.findAll());
    }

    @Override
    public void delete(long id) {
        Duration duration = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(duration);
    }
}
