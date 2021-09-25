package freelance.platform.api.converter.job;

import freelance.platform.api.bean.job.Job;
import freelance.platform.api.converter.PaymentTypeConverter;
import freelance.platform.api.converter.SkillConverter;
import freelance.platform.api.converter.client.ManagerConverter;
import freelance.platform.api.converter.proposal.ProposalConverter;
import freelance.platform.api.dto.job.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JobConverter {

    @Autowired
    ComplexityConverter complexityConverter;
    @Autowired
    DurationConverter durationConverter;
    @Autowired
    PaymentTypeConverter paymentTypeConverter;
    @Autowired
    SkillConverter skillConverter;
    @Autowired
    ManagerConverter managerConverter;
    @Autowired
    ProposalConverter proposalConverter;

    public Job toEntity(JobDto dto) {
        return Job.builder().id(dto.getId())
                .description(dto.getDescription())
                .paymentAmount(dto.getPaymentAmount())
                .build();
    }

    public List<Job> toEntities(List<JobDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public JobDto toDto(Job job) {
        return JobDto.builder().id(job.getId())
                .description(job.getDescription())
                .paymentAmount(job.getPaymentAmount())
                .paymentType(paymentTypeConverter.toDto(job.getPaymentType()))
                .complexity(complexityConverter.toDto(job.getComplexity()))
                .duration(durationConverter.toDto(job.getDuration()))
                .manager(job.getManager().getId())
                .proposals(proposalConverter.toDtos(job.getProposals()))
                .skill(skillConverter.toDto(job.getSkill()))
                .otherSkills(skillConverter.toDtos(job.getOtherSkills()))
                .build();
    }

    public List<JobDto> toDtos(List<Job> jobs) {
        return jobs.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<JobDto> toDtosPage(Page<Job> jobsPage) {
        return jobsPage.map(this::toDto);
    }

    public Stream<JobDto> toDtosStream(Stream<Job> jobsStream) {
        return jobsStream.map(this::toDto);
    }
}
