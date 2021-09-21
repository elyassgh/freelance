package freelance.platform.api.repository.job;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Stream<Job> findByManager(Manager manager);
    Stream<Job> findBySkill(Skill skill);
    Stream<Job> findByPaymentAmountIsGreaterThanEqual(Double minValue);
    Stream<Job> findByDescriptionContains(String query);
}
