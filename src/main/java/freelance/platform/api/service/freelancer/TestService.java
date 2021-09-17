package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.freelancer.Test;
import freelance.platform.api.dto.freelancer.TestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface TestService {

    public TestDto save(TestDto dto);
    public TestDto update(long id, TestDto dto);

    public TestDto findByTestName(String testName);
    public Stream<TestDto> findByTestNameContains(String testName);
    public Optional<Test> findById(long id);
    public TestDto findByIdDto(long id);
    public Page<Test> findAll(Pageable pageable);

    public void delete(long id);

}
