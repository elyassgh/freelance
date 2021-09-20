package freelance.platform.api.serviceImpl.freelancer;

import freelance.platform.api.bean.freelancer.Test;
import freelance.platform.api.converter.freelancer.TestConverter;
import freelance.platform.api.dto.freelancer.TestDto;
import freelance.platform.api.repository.freelancer.TestRepository;
import freelance.platform.api.service.freelancer.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository repository;
    @Autowired
    TestConverter converter;

    @Override
    public TestDto save(TestDto dto) {
        Test test = converter.toEntity(dto);
        return converter.toDto(repository.save(test));
    }

    @Override
    public TestDto update(long id, TestDto dto) {
        Test test = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if(dto.getTestLink() != null) test.setTestLink(dto.getTestLink());
        if(dto.getTestName() != null) test.setTestName(dto.getTestName());
        return converter.toDto(repository.save(test));
    }

    @Override
    public TestDto findByTestName(String testName) {
        return converter.toDto(repository.findByTestName(testName));
    }

    @Override
    public Stream<TestDto> findByTestNameContains(String testName) {
        return converter.toDtosStream(repository.findByTestNameContains(testName));
    }

    @Override
    public Optional<Test> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public TestDto findByIdDto(long id) {
        Test test = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(test);
    }

    @Override
    public Page<TestDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Test test = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(test);
    }
}
