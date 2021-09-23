package freelance.platform.api.repository;

import freelance.platform.api.bean.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

    PaymentType findByTypeName(String typeName);

}
