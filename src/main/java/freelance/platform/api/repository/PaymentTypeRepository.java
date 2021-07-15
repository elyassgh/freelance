package freelance.platform.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.PaymentType;

import java.util.stream.Stream;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

    PaymentType findByTypeName(String typeName);
    Stream<PaymentType> findByTypeNameContains(String typeName);

}
