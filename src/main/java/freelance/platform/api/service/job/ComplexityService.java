package freelance.platform.api.service.job;

import freelance.platform.api.bean.job.Complexity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ComplexityService {

    public Complexity save(Complexity complexity);
    public Complexity update(int id, Complexity complexity);

    public Optional<Complexity> findById(int id);
    public Page<Complexity> findAll(Pageable pageable);

    public Complexity delete(int id);

}
