package freelance.platform.api.repository.freelancer;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.freelancer.Certification;
import freelance.platform.api.bean.freelancer.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {

    Freelancer findByAccount(UserAccount account);
    Stream<Freelancer> findByLocation(String location);
    Stream<Freelancer> findByBioContains(String keyword);
    Stream<Freelancer> findByCertifications(Certification certification);
    Stream<Freelancer> findBySkills(Skill skill);
}
