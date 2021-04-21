package freelance.platform.api.repository.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.freelancer.Freelancer;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {

}
