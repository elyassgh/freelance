package freelance.platform.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
