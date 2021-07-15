package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.freelancer.Test;
import freelance.platform.api.bean.freelancer.TestResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TestResultService {

    public TestResult save(TestResult testResult);
    public TestResult update(int id, TestResult testResult);

    public TestResult findByTest(Test test);
    public Optional<Test> findById(int id);
    public Page<Test> findAll(Pageable pageable);

    public TestResult delete(int id);

}
