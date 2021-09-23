package freelance.platform.api.converter.freelancer;

import freelance.platform.api.bean.freelancer.TestResult;
import freelance.platform.api.dto.freelancer.TestResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TestResultConverter {

    @Autowired
    FreelancerConverter freelancerConverter;

    public TestResult toEntity(TestResultDto dto) {
        return TestResult.builder().id(dto.getId())
                .freelancer(freelancerConverter.toEntity(dto.getFreelancer()))
                .test(dto.getTest())
                .testResultLink(dto.getTestResultLink())
                .score(dto.getScore())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .displayOnProfile(dto.getDisplayOnProfile())
                .build();
    }

    public List<TestResult> toEntities(List<TestResultDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public TestResultDto toDto(TestResult testResult) {
        return TestResultDto.builder().id(testResult.getId())
                .displayOnProfile(testResult.getDisplayOnProfile())
                .score(testResult.getScore())
                .startTime(testResult.getStartTime())
                .endTime(testResult.getEndTime())
                .testResultLink(testResult.getTestResultLink())
                .test(testResult.getTest())
                .freelancer(freelancerConverter.toDto(testResult.getFreelancer()))
                .build();
    }

    public List<TestResultDto> toDtos(List<TestResult> results) {
        return results.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<TestResultDto> toDtosPage(Page<TestResult> resultsPage) {
        return resultsPage.map(this::toDto);
    }

    public Stream<TestResultDto> toDtosStream(Stream<TestResult> resultsStream) {
        return resultsStream.map(this::toDto);
    }

}
