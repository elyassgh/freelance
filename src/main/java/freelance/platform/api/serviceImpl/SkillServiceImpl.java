package freelance.platform.api.serviceImpl;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.converter.SkillConverter;
import freelance.platform.api.dto.SkillDto;
import freelance.platform.api.repository.SkillRepository;
import freelance.platform.api.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRepository repository;
    @Autowired
    SkillConverter converter;

    @Override
    public SkillDto save(SkillDto dto) {
        Skill skill = converter.toEntity(dto);
        return converter.toDto(repository.save(skill));
    }

    @Override
    public SkillDto update(long id, SkillDto dto) {
        Skill skill = repository.findById(id).orElseThrow(() -> new RuntimeException("not found !"));
        skill.setSkillName(dto.getSkillName());
        return converter.toDto(repository.save(skill));
    }

    @Override
    public SkillDto findBySkillName(String skillName) {
        return converter.toDto(repository.findBySkillName(skillName));
    }

    @Override
    public Stream<SkillDto> findBySkillNameContains(String skillName) {
        return converter.toDtosStream(repository.findBySkillNameContains(skillName));
    }

    @Override
    public Optional<Skill> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public SkillDto findByIdDto(long id) {
        Skill skill = repository.findById(id).orElseThrow(() -> new RuntimeException("not found !"));
        return converter.toDto(skill);
    }

    @Override
    public Page<SkillDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Skill skill = repository.findById(id).orElseThrow(() -> new RuntimeException("not found !"));
        repository.delete(skill);
    }
}
