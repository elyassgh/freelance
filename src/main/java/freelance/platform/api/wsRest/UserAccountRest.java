package freelance.platform.api.wsRest;

import freelance.platform.api.dto.UserAccountDto;
import freelance.platform.api.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freelance-api/v1/user-account")
public class UserAccountRest {

    @Autowired
    UserAccountService service;

    @PostMapping("/save")
    public UserAccountDto save(@RequestBody UserAccountDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public UserAccountDto update(@PathVariable long id, @RequestBody UserAccountDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/username")
    public UserAccountDto findByUserName(@RequestParam(name = "username") String userName) {
        return service.findByUserName(userName);
    }

    @GetMapping("/find/email")
    public UserAccountDto findByEmail(@RequestParam(name = "email") String email) {
        return service.findByEmail(email);
    }

    @GetMapping("/find/id/{id}")
    public UserAccountDto findById(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all/p/{p}/s/{s}")
    public Page<UserAccountDto> findAll(@PathVariable(name = "p") int page, @PathVariable(name = "s") int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
