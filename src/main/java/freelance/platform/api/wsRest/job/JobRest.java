package freelance.platform.api.wsRest.job;

import freelance.platform.api.dto.job.JobDto;
import freelance.platform.api.service.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/freelance-api/v1/job")
public class JobRest {

    @Autowired
    JobService service;

    @PostMapping("/save")
    public JobDto save(@RequestBody JobDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public JobDto update(@PathVariable long id, @RequestBody JobDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/manager/{managerId}")
    public List<JobDto> findByManager(@PathVariable long managerId) {
        return service.findByManager(managerId).collect(Collectors.toList());
    }

    @GetMapping("/find/skill/{skillId}")
    public List<JobDto> findBySkill(@PathVariable long skillId) {
        return service.findBySkill(skillId).collect(Collectors.toList());
    }

    @GetMapping("/find/all/min-amount")
    public List<JobDto> findByPaymentAmountIsGreaterThanEqual(@RequestParam(name = "minVal") Double minValue) {
        return service.findByPaymentAmountIsGreaterThanEqual(minValue).collect(Collectors.toList());
    }

    @GetMapping("/find/all/description")
    public List<JobDto> findByDescriptionContains(@RequestParam(name = "query") String query) {
        return service.findByDescriptionContains(query).collect(Collectors.toList());
    }

    @GetMapping("/find/id/{id}")
    public JobDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<JobDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
