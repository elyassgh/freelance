package freelance.platform.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
