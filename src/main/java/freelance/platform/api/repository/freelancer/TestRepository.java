package freelance.platform.api.repository.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.freelancer.Test;

import java.util.stream.Stream;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    Test findByTestName(String testName);
    Stream<Test> findByTestNameContains(String testName);
}
