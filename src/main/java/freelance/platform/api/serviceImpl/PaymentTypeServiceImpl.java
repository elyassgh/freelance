package freelance.platform.api.serviceImpl;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.converter.PaymentTypeConverter;
import freelance.platform.api.dto.PaymentTypeDto;
import freelance.platform.api.repository.PaymentTypeRepository;
import freelance.platform.api.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    PaymentTypeRepository repository;
    @Autowired
    PaymentTypeConverter converter;

    @Override
    public PaymentTypeDto save(PaymentTypeDto dto) {
        PaymentType paymentType = converter.toEntity(dto);
        return converter.toDto(repository.save(paymentType));
    }

    @Override
    public PaymentTypeDto update(long id, PaymentTypeDto dto) {
        PaymentType paymentType = findById(id).orElseThrow(()-> new RuntimeException("not found !"));
        paymentType.setTypeName(dto.getTypeName());
        return converter.toDto(repository.save(paymentType));
    }

    @Override
    public PaymentTypeDto findByTypeName(String typeName) {
        return converter.toDto(repository.findByTypeName(typeName));
    }

    @Override
    public Optional<PaymentType> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public PaymentTypeDto findByIdDto(long id) {
        PaymentType paymentType = findById(id).orElseThrow(()-> new RuntimeException("not found !"));
        return converter.toDto(paymentType);
    }

    @Override
    public Page<PaymentTypeDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        PaymentType paymentType = findById(id).orElseThrow(()-> new RuntimeException("not found !"));
        repository.delete(paymentType);
    }
}
