package freelance.platform.api.wsRest.proposal;

import freelance.platform.api.dto.proposal.ProposalDto;
import freelance.platform.api.service.proposal.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/freelance-api/v1/proposal")
public class ProposalRest {

    @Autowired
    ProposalService service;

    @PostMapping("/save")
    public ProposalDto save(@RequestBody ProposalDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public ProposalDto update(@PathVariable long id, @RequestBody ProposalDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/all/job/{jobId}")
    public Stream<ProposalDto> findByJob(@PathVariable long jobId) {
        return service.findByJob(jobId);
    }

    @GetMapping("/find/all/payment-amount")
    public Stream<ProposalDto> findByPaymentAmountBetween(@RequestParam(name = "min") Double minValue,
                                                          @RequestParam(name = "min") Double maxValue) {
        return service.findByPaymentAmountBetween(minValue, maxValue);
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
