package freelance.platform.api.repository.job;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.job.Complexity;

public interface ComplexityRepository extends JpaRepository<Complexity, Long> {

}
