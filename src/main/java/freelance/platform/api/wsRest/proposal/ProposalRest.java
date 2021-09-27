package freelance.platform.api.wsRest.proposal;

import freelance.platform.api.dto.proposal.ProposalDto;
import freelance.platform.api.service.proposal.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/freelance-api/v1/proposal")
public class ProposalRest {

    @Autowired
    ProposalService service;

    @PostMapping("/save/job/{jobId}/freelancer/{freelancerId}")
    public ProposalDto save(@PathVariable long jobId,
                            @PathVariable long freelancerId,
                            @RequestBody ProposalDto dto) {
        return service.save(jobId, freelancerId, dto);
    }

    @PutMapping("/update/id/{id}")
    public ProposalDto update(@PathVariable long id, @RequestBody ProposalDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/all/job/{jobId}")
    @Transactional(readOnly = true)
    public List<ProposalDto> findByJob(@PathVariable long jobId) {
        return service.findByJob(jobId).collect(Collectors.toList());
    }

    @GetMapping("/find/all/freelancer/{freelancerId}")
    @Transactional(readOnly = true)
    public List<ProposalDto> findByFreelancer(@PathVariable long freelancerId) {
        return service.findByFreelancer(freelancerId).collect(Collectors.toList());
    }

    @GetMapping("/find/all/payment-amount")
    @Transactional(readOnly = true)
    public List<ProposalDto> findByPaymentAmountBetween(@RequestParam(name = "min") Double minValue,
                                                          @RequestParam(name = "min") Double maxValue) {
        return service.findByPaymentAmountBetween(minValue, maxValue).collect(Collectors.toList());
    }

    @GetMapping("/find/id/{id}")
    public ProposalDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<ProposalDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
