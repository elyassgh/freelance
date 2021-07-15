package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.freelancer.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface TestService {

    public Test save(Test test);
    public Test update(int id, Test test);

    public Test findByTestName(String testName);
    public Stream<Test> findByTestNameContains(String testName);
    public Optional<Test> findById(int id);
    public Page<Test> findAll(Pageable pageable);

    public Test delete(int id);

}
