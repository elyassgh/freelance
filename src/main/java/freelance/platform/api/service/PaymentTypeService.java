package freelance.platform.api.service;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.dto.PaymentTypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface PaymentTypeService {

    public PaymentTypeDto save(PaymentTypeDto dto);
    public PaymentTypeDto update(long id, PaymentTypeDto dto);

    public PaymentTypeDto findByTypeName(String typeName);
    public Stream<PaymentTypeDto> findByTypeNameContains(String typeName);
    public Optional<PaymentType> findById(long id);
    public Page<PaymentTypeDto> findAll(Pageable pageable);

    public void delete(long id);

}
