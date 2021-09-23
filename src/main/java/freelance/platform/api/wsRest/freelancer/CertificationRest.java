package freelance.platform.api.wsRest.freelancer;

import freelance.platform.api.dto.freelancer.CertificationDto;
import freelance.platform.api.service.freelancer.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/freelance-api/v1/certification")
public class CertificationRest {

    @Autowired
    CertificationService service;

    @PostMapping("/save")
    public CertificationDto save(@RequestBody CertificationDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public CertificationDto update(@PathVariable long id, @RequestBody CertificationDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/all/name/{name}")
    public Stream<CertificationDto> findByCertificationNameContains(@PathVariable String name) {
        return service.findByCertificationNameContains(name);
    }

    @GetMapping("/find/all/provider/{provider}")
    public Stream<CertificationDto> findByCertificationProviderContains(@PathVariable String provider) {
        return service.findByCertificationProviderContains(provider);
    }

    @GetMapping("/find/all/freelancer/{freelancerId}")
    public Stream<CertificationDto> findByFreelancer(@PathVariable long freelancerId) {
        return service.findByFreelancer(freelancerId);
    }

    @GetMapping("/find/id/{id}")
    public CertificationDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<CertificationDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
