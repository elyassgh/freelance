package freelance.platform.api.repository.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.job.Complexity;

@Repository
public interface ComplexityRepository extends JpaRepository<Complexity, Long> {

}
