package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.freelancer.Certification;
import freelance.platform.api.bean.freelancer.Freelancer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface FreelancerService {

    public Freelancer save(Freelancer freelancer);
    public Freelancer update(int id, Freelancer freelancer);

    public Freelancer findByAccount(UserAccount account);
    public Stream<Freelancer> findByLocation(String location);
    public Stream<Freelancer> findByBioContains(String keyword);
    public Stream<Freelancer> findByCertifications(Certification certification);
    public Stream<Freelancer> findBySkills(Skill skill);
    public Optional<Freelancer> findById(int id);
    public Page<Freelancer> findAll(Pageable pageable);

    public Freelancer delete(int id);

}
