package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.proposal.Message;
import freelance.platform.api.dto.proposal.MessageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface MessageService {

    public MessageDto save(MessageDto dto);
    public MessageDto update(long id, MessageDto dto);

    public Stream<MessageDto> findByManagerAndFreelancer(long managerId, long freelancerId);
    public Optional<Message> findById(long id);
    public MessageDto findByIdDto(long id);
    public Page<MessageDto> findAll(Pageable pageable);

    public void delete(long id);

}
