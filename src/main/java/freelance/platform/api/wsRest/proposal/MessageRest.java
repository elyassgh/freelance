package freelance.platform.api.wsRest.proposal;

import freelance.platform.api.bean.proposal.Message;
import freelance.platform.api.dto.proposal.MessageDto;
import freelance.platform.api.service.proposal.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/freelance-api/v1/message")
public class MessageRest {

    @Autowired
    MessageService service;

    @PostMapping("/save")
    public MessageDto save(@RequestBody MessageDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public MessageDto update(@PathVariable long id, @RequestBody MessageDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/all/manager/{managerId}/freelancer/{freelancerId}")
    public Stream<MessageDto> findByManagerAndFreelancer(@PathVariable long managerId, @PathVariable long freelancerId) {
        return service.findByManagerAndFreelancer(managerId, freelancerId);
    }

    @GetMapping("/find/id/{id}")
    public Optional<Message> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<MessageDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
