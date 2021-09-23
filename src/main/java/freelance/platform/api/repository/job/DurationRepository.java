package freelance.platform.api.repository.job;

import freelance.platform.api.bean.job.Duration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationRepository extends JpaRepository<Duration, Long> {

}
