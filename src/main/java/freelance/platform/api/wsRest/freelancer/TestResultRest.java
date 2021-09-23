package freelance.platform.api.wsRest.freelancer;

import freelance.platform.api.dto.freelancer.TestResultDto;
import freelance.platform.api.service.freelancer.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freelance-api/v1/test-result")
public class TestResultRest {

    @Autowired
    TestResultService service;

    @PostMapping("/save")
    public TestResultDto save(@RequestBody TestResultDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public TestResultDto update(@PathVariable long id, @RequestBody TestResultDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/test/{testId}")
    public TestResultDto findByTest(@PathVariable long testId) {
        return service.findByTest(testId);
    }

    @GetMapping("/find/id/{id}")
    public TestResultDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<TestResultDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
