package freelance.platform.api.converter.freelancer;

import freelance.platform.api.bean.freelancer.Test;
import freelance.platform.api.dto.freelancer.TestDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TestConverter {

    public Test toEntity(TestDto dto) {
        return Test.builder().id(dto.getId())
                .testLink(dto.getTestLink())
                .testName(dto.getTestName())
                .build();
    }

    public List<Test> toEntities(List<TestDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public TestDto toDto(Test test) {
        return TestDto.builder().id(test.getId())
                .testLink(test.getTestLink())
                .testName(test.getTestName())
                .build();
    }

    public List<TestDto> toDtos(List<Test> tests) {
        return tests.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<TestDto> toDtosPage(Page<Test> testsPage) {
        return testsPage.map(this::toDto);
    }

    public Stream<TestDto> toDtosStream(Stream<Test> testsStream) {
        return testsStream.map(this::toDto);
    }

}
