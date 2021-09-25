package freelance.platform.api.wsRest.job;

import freelance.platform.api.dto.job.JobDto;
import freelance.platform.api.service.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    public List<JobDto> findByManager(@PathVariable long managerId) {
        return service.findByManager(managerId).collect(Collectors.toList());
    }

    @GetMapping("/find/all/min-amount/p/{p}/s/{s}")
    public Page<JobDto> findByPaymentAmountIsGreaterThanEqual(@RequestParam(name = "minVal") Double minValue,
                                                              @PathVariable(name = "p") int page,
                                                              @PathVariable(name = "s") int size) {
        return service.findByPaymentAmountIsGreaterThanEqual(minValue, PageRequest.of(page, size));
    }

    @GetMapping("/find/id/{id}")
    public JobDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/skill/{skillId}/p/{p}/s/{s}")
    public Page<JobDto> findBySkill(@PathVariable long skillId, @PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findBySkill(skillId, PageRequest.of(page, size));
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
