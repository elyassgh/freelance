package freelance.platform.api.wsRest.client;

import freelance.platform.api.dto.client.ManagerDto;
import freelance.platform.api.service.client.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional(readOnly = true)
    public List<ManagerDto> findByCompany(@PathVariable Long companyId) {
        return service.findByCompany(companyId).collect(Collectors.toList());
    }

    @GetMapping("/find/location/{location}")
    @Transactional(readOnly = true)
    public List<ManagerDto> findByLocation(@PathVariable String location) {
        return service.findByLocation(location).collect(Collectors.toList());
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
