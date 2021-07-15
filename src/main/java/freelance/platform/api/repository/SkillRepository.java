package freelance.platform.api.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Skill findBySkillName(String skillName);
    Stream<Skill> findBySkillNameContains(String skillName);

}
