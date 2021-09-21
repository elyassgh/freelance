package freelance.platform.api.service.job;

import freelance.platform.api.bean.job.Complexity;
import freelance.platform.api.dto.job.ComplexityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ComplexityService {

    public ComplexityDto save(ComplexityDto dto);
    public ComplexityDto update(long id, ComplexityDto dto);

    public Optional<Complexity> findById(long id);
    public ComplexityDto findByIdDto(long id);
    public List<ComplexityDto> findAll();

    public void delete(long id);

}
