package freelance.platform.api.wsRest.client;

import freelance.platform.api.dto.client.CompanyDto;
import freelance.platform.api.service.client.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freelance-api/v1/company")
public class CompanyRest {

    @Autowired
    CompanyService service;

    @PostMapping("/save")
    public CompanyDto save(CompanyDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public CompanyDto update(@PathVariable long id, @RequestBody CompanyDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/name")
    public CompanyDto findByName(@RequestParam(name = "name") String name) {
        return service.findByName(name);
    }

    @GetMapping("/find/id/{id}")
    public CompanyDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<CompanyDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
