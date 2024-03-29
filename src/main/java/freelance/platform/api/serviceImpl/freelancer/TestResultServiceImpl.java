package freelance.platform.api.serviceImpl.freelancer;

import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.freelancer.Test;
import freelance.platform.api.bean.freelancer.TestResult;
import freelance.platform.api.converter.freelancer.TestResultConverter;
import freelance.platform.api.dto.freelancer.TestResultDto;
import freelance.platform.api.repository.freelancer.TestResultRepository;
import freelance.platform.api.service.freelancer.FreelancerService;
import freelance.platform.api.service.freelancer.TestResultService;
import freelance.platform.api.service.freelancer.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TestResultServiceImpl implements TestResultService {

    @Autowired
    TestResultRepository repository;
    @Autowired
    TestResultConverter converter;
    @Autowired
    TestService testService;
    @Autowired
    FreelancerService freelancerService;

    @Override
    public TestResultDto save(TestResultDto dto) {
        Test test = testService.findById(dto.getTest()).orElseThrow(() -> new RuntimeException("not found"));
        Freelancer freelancer = freelancerService.findById(dto.getFreelancer()).orElseThrow(() -> new RuntimeException("not found"));
        TestResult testResult = converter.toEntity(dto);
        testResult.setTest(test);
        testResult.setFreelancer(freelancer);
        return converter.toDto(repository.save(testResult));
    }

    @Override
    public TestResultDto update(long id, TestResultDto dto) {
        TestResult testResult = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (dto.getDisplayOnProfile() != null) testResult.setDisplayOnProfile(dto.getDisplayOnProfile());
        //  if (dto.getScore() != null) testResult.setScore(dto.getScore());
        return converter.toDto(repository.save(testResult));
    }

    @Override
    public Stream<TestResultDto> findByTest(long testId) {
        Test test = testService.findById(testId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findByTest(test));
    }

    @Override
    public Stream<TestResultDto> findByFreelancer(long freelancerId) {
        Freelancer freelancer = freelancerService.findById(freelancerId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findByFreelancer(freelancer));
    }

    @Override
    public Optional<TestResult> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public TestResultDto findByIdDto(long id) {
        TestResult testResult = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(testResult);
    }

    @Override
    public Page<TestResultDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        TestResult testResult = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(testResult);
    }
}
