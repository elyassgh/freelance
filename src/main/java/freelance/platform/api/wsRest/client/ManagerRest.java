package freelance.platform.api.wsRest.client;

import freelance.platform.api.dto.client.ManagerDto;
import freelance.platform.api.service.client.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/freelance-api/v1/manager")
public class ManagerRest {

    @Autowired
    ManagerService service;

    @PostMapping("/save")
    public ManagerDto save(@RequestBody ManagerDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public ManagerDto update(@PathVariable long id, @RequestBody ManagerDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/company/{companyId}")
    public Stream<ManagerDto> findByCompany(@PathVariable Long companyId) {
        return service.findByCompany(companyId);
    }

    @GetMapping("/find/location/{location}")
    public Stream<ManagerDto> findByLocation(@PathVariable String location) {
        return service.findByLocation(location);
    }

    @GetMapping("/find/account/{userAccountId}")
    public ManagerDto findByAccount(@PathVariable Long userAccountId) {
        return service.findByAccount(userAccountId);
    }

    @GetMapping("/find/id/{id}")
    public ManagerDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<ManagerDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
