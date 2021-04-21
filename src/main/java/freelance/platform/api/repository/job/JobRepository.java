package freelance.platform.api.repository.job;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.job.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
