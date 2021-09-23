package freelance.platform.api.repository.job;

import freelance.platform.api.bean.job.Complexity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplexityRepository extends JpaRepository<Complexity, Long> {

}
