package freelance.platform.api.wsRest;

import freelance.platform.api.dto.SkillDto;
import freelance.platform.api.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/freelance-api/v1/skill")
public class SkillRest {

    @Autowired
    SkillService skillService;

    @PostMapping("/save")
    public SkillDto save(@RequestBody SkillDto dto) {
        return skillService.save(dto);
    }
    @PutMapping("/update/id/{id}")
    public SkillDto update(@PathVariable long id, @RequestBody SkillDto dto) {
        return skillService.update(id, dto);
    }

    @GetMapping("/find/skill-name")
    public SkillDto findBySkillName(@RequestParam(name = "skillName") String skillName) {
        return skillService.findBySkillName(skillName);
    }

    @GetMapping("/find/all/skill-name")
    public Stream<SkillDto> findBySkillNameContains(@RequestParam(name = "skillName") String skillName) {
        return skillService.findBySkillNameContains(skillName);
    }

    @GetMapping("/find/id/{id}")
    public SkillDto findByIdDto(@PathVariable long id) {
        return skillService.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<SkillDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return skillService.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        skillService.delete(id);
    }
}
