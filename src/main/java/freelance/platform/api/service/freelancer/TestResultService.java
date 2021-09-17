package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.freelancer.Test;
import freelance.platform.api.bean.freelancer.TestResult;
import freelance.platform.api.dto.freelancer.TestResultDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TestResultService {

    public TestResultDto save(TestResultDto dto);
    public TestResultDto update(long id, TestResultDto dto);

    public TestResultDto findByTest(long testId);
    public Optional<TestResult> findById(long id);
    public TestResultDto findByIdDto(long id);
    public Page<Test> findAll(Pageable pageable);

    public void delete(long id);

}
