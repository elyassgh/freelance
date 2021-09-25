package freelance.platform.api.wsRest.freelancer;

import freelance.platform.api.dto.freelancer.TestDto;
import freelance.platform.api.service.freelancer.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/freelance-api/v1/test")
public class TestRest {

    @Autowired
    TestService service;

    @PostMapping("/save")
    public TestDto save(@RequestBody TestDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public TestDto update(@PathVariable long id, @RequestBody TestDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/name/{testName}")
    public TestDto findByTestName(@PathVariable String testName) {
        return service.findByTestName(testName);
    }

    @GetMapping("/find/all/name/{testName}")
    @Transactional(readOnly = true)
    public List<TestDto> findByTestNameContains(@PathVariable String testName) {
        return service.findByTestNameContains(testName).collect(Collectors.toList());
    }

    @GetMapping("/find/id/{id}")
    public TestDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<TestDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
