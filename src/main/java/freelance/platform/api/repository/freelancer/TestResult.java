package freelance.platform.api.repository.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResult extends JpaRepository<TestResult, Long> {

}
