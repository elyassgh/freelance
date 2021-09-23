package freelance.platform.api.wsRest.freelancer;

import freelance.platform.api.dto.freelancer.FreelancerDto;
import freelance.platform.api.service.freelancer.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/freelance-api/v1/freelancer")
public class FreelancerRest {

    @Autowired
    FreelancerService service;

    @PostMapping("/save")
    public FreelancerDto save(@RequestBody FreelancerDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public FreelancerDto update(@PathVariable long id, @RequestBody FreelancerDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/account/{accountId}")
    public FreelancerDto findByAccount(@PathVariable long accountId) {
        return service.findByAccount(accountId);
    }

    @GetMapping("/find/all/location/{location}")
    public Stream<FreelancerDto> findByLocation(@PathVariable String location) {
        return service.findByLocation(location);
    }

    @GetMapping("/find/all/bio")
    public Stream<FreelancerDto> findByBioContains(@RequestParam(name = "keyword") String keyword) {
        return service.findByBioContains(keyword);
    }

    @GetMapping("/find/id/{id}")
    public FreelancerDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<FreelancerDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
