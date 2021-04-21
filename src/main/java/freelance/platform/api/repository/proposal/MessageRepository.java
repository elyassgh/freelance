package freelance.platform.api.repository.proposal;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.proposal.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
