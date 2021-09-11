package freelance.platform.api.service;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.dto.SkillDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface SkillService {

    public SkillDto save(SkillDto dto);
    public SkillDto update(long id, SkillDto dto);

    public SkillDto findBySkillName(String skillName);
    public Stream<SkillDto> findBySkillNameContains(String skillName);
    public Optional<Skill> findById(long id);
    public Page<SkillDto> findAll(Pageable pageable);

    public void delete(long id);

}
