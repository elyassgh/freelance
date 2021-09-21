package freelance.platform.api.serviceImpl.job;

import freelance.platform.api.bean.job.Complexity;
import freelance.platform.api.converter.job.ComplexityConverter;
import freelance.platform.api.dto.job.ComplexityDto;
import freelance.platform.api.repository.job.ComplexityRepository;
import freelance.platform.api.service.job.ComplexityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplexityServiceImpl implements ComplexityService {

    @Autowired
    ComplexityRepository repository;
    @Autowired
    ComplexityConverter converter;

    @Override
    public ComplexityDto save(ComplexityDto dto) {
        Complexity complexity = converter.toEntity(dto);
        return converter.toDto(repository.save(complexity));
    }

    @Override
    public ComplexityDto update(long id, ComplexityDto dto) {
        Complexity complexity = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (dto.getComplexityText() != null) complexity.setComplexityText(dto.getComplexityText());
        return converter.toDto(repository.save(complexity));
    }

    @Override
    public Optional<Complexity> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<ComplexityDto> findAll() {
        return converter.toDtos(repository.findAll());
    }

    @Override
    public void delete(long id) {
        Complexity complexity = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(complexity);
    }
}
