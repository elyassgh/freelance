package freelance.platform.api.repository;

import freelance.platform.api.bean.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Skill findBySkillName(String skillName);
    Stream<Skill> findBySkillNameContains(String skillName);

}
