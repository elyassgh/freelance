package freelance.platform.api.service.job;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.job.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface JobService {

    public Job save(Job job);
    public Job update(int id, Job job);

    public Stream<Job> findByManager(Manager manager);
    public Stream<Job> findBySkill(Skill skill);
    public Stream<Job> findByPaymentAmountIsGreaterThanEqual(Double minValue);
    public Stream<Job> findByDescriptionContains(String query);
    public Stream<Job> findByOtherSkillsContaining(List<Skill> skills);
    public Optional<Job> findById(int id);
    public Page<Job> findAll(Pageable pageable);

    public Job delete(int id);

}
