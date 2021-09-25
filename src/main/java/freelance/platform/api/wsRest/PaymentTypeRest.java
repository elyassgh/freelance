package freelance.platform.api.wsRest;

import freelance.platform.api.dto.PaymentTypeDto;
import freelance.platform.api.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelance-api/v1/payment-type")
public class PaymentTypeRest {

    @Autowired
    PaymentTypeService service;

    @PostMapping("/save")
    public PaymentTypeDto save(@RequestBody PaymentTypeDto dto) {
        return service.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public PaymentTypeDto update(@PathVariable long id, @RequestBody PaymentTypeDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/find/typename")
    public PaymentTypeDto findByTypeName(@RequestParam(name = "typeName") String typeName) {
        return service.findByTypeName(typeName);
    }

    @GetMapping("/find/id/{id}")
    public PaymentTypeDto findByIdDto(@PathVariable long id) {
        return service.findByIdDto(id);
    }

    @GetMapping("/find/all")
    public List<PaymentTypeDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
