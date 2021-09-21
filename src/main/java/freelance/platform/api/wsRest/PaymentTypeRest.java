package freelance.platform.api.wsRest;

import freelance.platform.api.dto.PaymentTypeDto;
import freelance.platform.api.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freelance-api/v1/payment-type")
public class PaymentTypeRest {

    @Autowired
    PaymentTypeService paymentTypeService;

    @PostMapping("/save")
    public PaymentTypeDto save(@RequestBody PaymentTypeDto dto) {
        return paymentTypeService.save(dto);
    }

    @PutMapping("/update/id/{id}")
    public PaymentTypeDto update(@PathVariable long id, @RequestBody PaymentTypeDto dto) {
        return paymentTypeService.update(id, dto);
    }

    @GetMapping("/find/typename")
    public PaymentTypeDto findByTypeName(@RequestParam(name = "typeName") String typeName) {
        return paymentTypeService.findByTypeName(typeName);
    }

    @GetMapping("/find/id/{id}")
    public PaymentTypeDto findByIdDto(@PathVariable long id) {
        return paymentTypeService.findByIdDto(id);
    }

    @GetMapping("/find/all")
    public Page<PaymentTypeDto> findAll(Pageable pageable) {
        return paymentTypeService.findAll(pageable);
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable long id) {
        paymentTypeService.delete(id);
    }
}
