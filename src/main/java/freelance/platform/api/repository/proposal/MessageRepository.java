package freelance.platform.api.repository.proposal;

import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.proposal.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Stream<Message> findByManagerAndFreelancer(Manager manager, Freelancer freelancer);

}
