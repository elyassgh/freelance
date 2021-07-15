package freelance.platform.api.service;

import freelance.platform.api.bean.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface SkillService {

    public void save(Skill skill);
    public void update(int id, Skill skill);

    public Skill findBySkillName(String skillName);
    public Stream<Skill> findBySkillNameContains(String skillName);
    public Optional<Skill> findById(int id);
    public Page<Skill> findAll(Pageable pageable);

    public void delete(int id);

}
