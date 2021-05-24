package freelance.platform.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.PaymentType;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

    List<PaymentType> findAll();

    PaymentType findByTypeName(String typeName);

}
