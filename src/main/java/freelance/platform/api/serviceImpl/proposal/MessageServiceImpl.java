package freelance.platform.api.serviceImpl.proposal;

import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.proposal.Message;
import freelance.platform.api.converter.proposal.MessageConverter;
import freelance.platform.api.dto.proposal.MessageDto;
import freelance.platform.api.repository.proposal.MessageRepository;
import freelance.platform.api.service.client.ManagerService;
import freelance.platform.api.service.freelancer.FreelancerService;
import freelance.platform.api.service.proposal.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository repository;
    @Autowired
    MessageConverter converter;
    @Autowired
    ManagerService managerService;
    @Autowired
    FreelancerService freelancerService;

    @Override
    public MessageDto save(MessageDto dto) {
        Manager manager = managerService.findById(dto.getManager().getId()).orElseThrow(() -> new RuntimeException("not found"));
        Freelancer freelancer = freelancerService.findById(dto.getFreelance().getId()).orElseThrow(() -> new RuntimeException("not found"));
        Message message = converter.toEntity(dto);
        message.setManager(manager);
        message.setFreelancer(freelancer);
        return converter.toDto(repository.save(message));
    }

    @Override
    public MessageDto update(long id, MessageDto dto) {
        Message message = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        message.setMessageText(dto.getMessageText());
        return converter.toDto(repository.save(message));
    }

    @Override
    public Stream<MessageDto> findByManagerAndFreelance(long managerId, long freelancerId) {
        Manager manager = managerService.findById(managerId).orElseThrow(() -> new RuntimeException("not found"));
        Freelancer freelancer = freelancerService.findById(freelancerId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDtosStream(repository.findByManagerAndFreelance(manager, freelancer));
    }

    @Override
    public Optional<Message> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public MessageDto findByIdDto(long id) {
        Message message = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(message);
    }

    @Override
    public Page<MessageDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Message message = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(message);
    }
}
