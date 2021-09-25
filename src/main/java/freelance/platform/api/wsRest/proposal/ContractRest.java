package freelance.platform.api.wsRest.proposal;

import freelance.platform.api.dto.proposal.ContractDto;
import freelance.platform.api.service.proposal.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/freelance-api/v1/contract")
public class ContractRest {

    @Autowired
    ContractService service;

    @PostMapping("/save")
    public ContractDto save(@RequestBody ContractDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public ContractDto update(@PathVariable long id, @RequestBody ContractDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/proposal/{proposalId}")
    public ContractDto findByProposal(@PathVariable long proposalId) {
        return service.findByProposal(proposalId);
    }

    @GetMapping("/find/all/company/{companyId}")
    @Transactional(readOnly = true)
    public List<ContractDto> findByCompany(@PathVariable long companyId) {
        return service.findByCompany(companyId).collect(Collectors.toList());
    }

    @GetMapping("/find/all/freelancer/{freelancerId}")
    @Transactional(readOnly = true)
    public List<ContractDto> findByFreelancer(@PathVariable long freelancerId) {
        return service.findByFreelancer(freelancerId).collect(Collectors.toList());
    }

    @GetMapping("/find/id/{id}")
    public ContractDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<ContractDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
