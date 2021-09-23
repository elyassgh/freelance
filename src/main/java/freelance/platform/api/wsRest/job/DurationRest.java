package freelance.platform.api.wsRest.job;

import freelance.platform.api.dto.job.DurationDto;
import freelance.platform.api.service.job.DurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelance-api/v1/duration")
public class DurationRest {

    @Autowired
    DurationService service;

    @PostMapping("/save")
    public DurationDto save(@RequestBody DurationDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public DurationDto update(@PathVariable long id, @RequestBody DurationDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/id/{id}")
    public DurationDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all")
    public List<DurationDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
