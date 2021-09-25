package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.freelancer.TestResult;
import freelance.platform.api.dto.freelancer.TestResultDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface TestResultService {

    public TestResultDto save(TestResultDto dto);
    public TestResultDto update(long id, TestResultDto dto);

    public Stream<TestResultDto> findByTest(long testId);
    public Stream<TestResultDto> findByFreelancer(long freelancerId);
    public Optional<TestResult> findById(long id);
    public TestResultDto findByIdDto(long id);
    public Page<TestResultDto> findAll(Pageable pageable);

    public void delete(long id);

}
