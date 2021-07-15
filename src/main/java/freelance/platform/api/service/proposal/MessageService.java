package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.proposal.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface MessageService {

    public Message save(Message message);
    public Message update(int id, Message message);

    public Stream<Message> findByManagerAndFreelance(Manager manager, Freelancer freelancer);
    public Optional<Message> findById(int id);
    public Page<Message> findAll(Pageable pageable);

    public Message delete(int id);

}
