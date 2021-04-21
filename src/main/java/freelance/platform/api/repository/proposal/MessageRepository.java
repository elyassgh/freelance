package freelance.platform.api.repository.proposal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.proposal.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
