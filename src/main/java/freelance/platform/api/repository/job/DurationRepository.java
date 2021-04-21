package freelance.platform.api.repository.job;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.job.Duration;

public interface DurationRepository extends JpaRepository<Duration, Long> {

}
