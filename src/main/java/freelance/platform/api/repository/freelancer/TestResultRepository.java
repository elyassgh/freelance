package freelance.platform.api.repository.freelancer;

import freelance.platform.api.bean.freelancer.Test;
import freelance.platform.api.bean.freelancer.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    TestResult findByTest(Test test);
}
