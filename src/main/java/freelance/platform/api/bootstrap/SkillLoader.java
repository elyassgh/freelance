package freelance.platform.api.bootstrap;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SkillLoader implements ApplicationRunner {

    @Autowired
    SkillRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Skill(null, "Web development"));
        repository.save(new Skill(null, "Mobile development"));
        repository.save(new Skill(null, "Design"));
        repository.save(new Skill(null, "Web design"));
        repository.save(new Skill(null, "Logo design"));
        repository.save(new Skill(null, "Social media"));
        repository.save(new Skill(null, "Data analysis"));
        repository.save(new Skill(null, "Writing & research"));
        repository.save(new Skill(null, "Project management"));
        repository.save(new Skill(null, "Marketing"));
        repository.save(new Skill(null, "Management"));
        repository.save(new Skill(null, "Accountability"));
        repository.save(new Skill(null, "Statistics"));
        repository.save(new Skill(null, "Data mining"));
        repository.save(new Skill(null, "Artificial Intelligent"));
        repository.save(new Skill(null, "E-commerce"));
        repository.save(new Skill(null, "Voice acting"));
        repository.save(new Skill(null, "Auditing & Examination"));
        repository.save(new Skill(null, "Communication"));
        repository.save(new Skill(null, "Testing"));
        repository.save(new Skill(null, "Coaching"));
        repository.save(new Skill(null, "Cuisine"));
        repository.save(new Skill(null, "Sport Training"));
        repository.save(new Skill(null, "Documentation & Copyrighting"));
    }
}
