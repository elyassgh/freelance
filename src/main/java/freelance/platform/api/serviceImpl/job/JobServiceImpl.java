package freelance.platform.api.serviceImpl.job;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.job.Complexity;
import freelance.platform.api.bean.job.Duration;
import freelance.platform.api.bean.job.Job;
import freelance.platform.api.converter.job.JobConverter;
import freelance.platform.api.dto.job.JobDto;
import freelance.platform.api.repository.job.JobRepository;
import freelance.platform.api.service.PaymentTypeService;
import freelance.platform.api.service.SkillService;
import freelance.platform.api.service.client.ManagerService;
import freelance.platform.api.service.job.ComplexityService;
import freelance.platform.api.service.job.DurationService;
import freelance.platform.api.service.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository repository;
    @Autowired
    JobConverter converter;
    @Autowired
    PaymentTypeService paymentTypeService;
    @Autowired
    ComplexityService complexityService;
    @Autowired
    DurationService durationService;
    @Autowired
    SkillService skillService;
    @Autowired
    ManagerService managerService;

    @Override
    public JobDto save(JobDto dto) {
        Job job = converter.toEntity(dto);
        return converter.toDto(repository.save(job));
    }

    @Override
    public JobDto update(long id, JobDto dto) {
        Job job = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (dto.getDescription() != null) job.setDescription(dto.getDescription());
        if (dto.getPaymentAmount() != null) job.setPaymentAmount(dto.getPaymentAmount());
        if (dto.getPaymentType() != null) {
            PaymentType paymentType = paymentTypeService.findById(dto.getPaymentType().getId()).orElseThrow(() -> new RuntimeException("not found"));
            job.setPaymentType(paymentType);
        }
        if (dto.getDuration() != null) {
            Duration duration = durationService.findById(dto.getDuration().getId()).orElseThrow(() -> new RuntimeException("not found"));
            job.setDuration(duration);
        }
        if (dto.getComplexity() != null) {
            Complexity complexity = complexityService.findById(dto.getComplexity().getId()).orElseThrow(() -> new RuntimeException("not found"));
            job.setComplexity(complexity);
        }
        if (dto.getSkill() != null) {
            Skill skill = skillService.findById(dto.getSkill().getId()).orElseThrow(() -> new RuntimeException("not found"));
            job.setSkill(skill);
        }
        if (dto.getOtherSkills() != null && !dto.getOtherSkills().isEmpty()) {
            List<Skill> skills = new ArrayList<Skill>();
            dto.getOtherSkills().forEach(elem -> {
                Skill skill = skillService.findById(elem.getId()).orElseThrow(() -> new RuntimeException("not found"));
                skills.add(skill);
            });
            job.setOtherSkills(skills);
        }
        return converter.toDto(repository.save(job));
    }

    @Override
    public Stream<JobDto> findByManager(long mangerId) {
        Manager manager = managerService.findById(mangerId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findByManager(manager));
    }

    @Override
    public Stream<JobDto> findBySkill(long skillId) {
        Skill skill = skillService.findById(skillId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findBySkill(skill));
    }

    @Override
    public Stream<JobDto> findByPaymentAmountIsGreaterThanEqual(Double minValue) {
        return converter.toDtosStream(repository.findByPaymentAmountIsGreaterThanEqual(minValue));
    }

    @Override
    public Stream<JobDto> findByDescriptionContains(String query) {
        return converter.toDtosStream(repository.findByDescriptionContains(query));
    }

    @Override
    public Optional<Job> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public JobDto findByIdDto(long id) {
        Job job = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(job);
    }

    @Override
    public Page<JobDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Job job = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(job);
    }
}
