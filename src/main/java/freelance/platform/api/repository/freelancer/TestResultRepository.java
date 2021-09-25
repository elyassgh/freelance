package freelance.platform.api.repository.freelancer;

import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.freelancer.Test;
import freelance.platform.api.bean.freelancer.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

    Stream<TestResult> findByTest(Test test);
    Stream<TestResult> findByFreelancer(Freelancer freelancer);
}
