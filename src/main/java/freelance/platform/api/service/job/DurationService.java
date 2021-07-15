package freelance.platform.api.service.job;

import freelance.platform.api.bean.job.Duration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DurationService {

    public Duration save(Duration duration);
    public Duration update(int id, Duration duration);

    public Optional<Duration> findById(int id);
    public Page<Duration> findAll(Pageable pageable);

    public Duration delete(int id);

}
