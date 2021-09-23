package freelance.platform.api.wsRest.proposal;

import freelance.platform.api.dto.proposal.CatalogDto;
import freelance.platform.api.service.proposal.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelance-api/v1/catalog")
public class CatalogRest {

    @Autowired
    CatalogService service;

    @PostMapping("/save")
    public CatalogDto save(@RequestBody CatalogDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public CatalogDto update(@PathVariable long id, @RequestBody CatalogDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/id/{id}")
    public CatalogDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all}")
    public List<CatalogDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
