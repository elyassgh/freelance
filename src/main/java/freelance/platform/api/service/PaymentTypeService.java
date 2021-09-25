package freelance.platform.api.service;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.dto.PaymentTypeDto;

import java.util.List;
import java.util.Optional;

public interface PaymentTypeService {

    public PaymentTypeDto save(PaymentTypeDto dto);
    public PaymentTypeDto update(long id, PaymentTypeDto dto);

    public PaymentTypeDto findByTypeName(String typeName);
    public Optional<PaymentType> findById(long id);
    public PaymentTypeDto findByIdDto(long id);
    public List<PaymentTypeDto> findAll();

    public void delete(long id);

}
