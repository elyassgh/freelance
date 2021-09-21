package freelance.platform.api.wsRest.job;

import freelance.platform.api.dto.job.ComplexityDto;
import freelance.platform.api.service.job.ComplexityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelance-api/v1/complexity")
public class ComplexityRest {

    @Autowired
    ComplexityService complexityService;

    @PostMapping("/save")
    public ComplexityDto save(@RequestBody ComplexityDto dto) {
        return complexityService.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public ComplexityDto update(@PathVariable long id, @RequestBody ComplexityDto dto) {
        return complexityService.update(id, dto);
    }
    @GetMapping("/find/id/{id}")
    public ComplexityDto findByIdDto(@PathVariable long id) {
        return complexityService.findByIdDto(id);
    }

    @GetMapping("/find/all")
    public List<ComplexityDto> findAll() {
        return complexityService.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        complexityService.delete(id);
    }
}
