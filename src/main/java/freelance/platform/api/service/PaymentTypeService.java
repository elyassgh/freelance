package freelance.platform.api.service;

import freelance.platform.api.bean.PaymentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.Stream;

public interface PaymentTypeService {

    public PaymentType save(PaymentType paymentType);
    public PaymentType update(int id, PaymentType paymentType);

    public PaymentType findByTypeName(String typeName);
    public Stream<PaymentType> findByTypeNameContains(String typeName);
    public Optional<PaymentType> findById(int id);
    public Page<PaymentType> findAll(Pageable pageable);

    public PaymentType delete(int id);

}
