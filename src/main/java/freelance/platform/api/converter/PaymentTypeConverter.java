package freelance.platform.api.converter;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.dto.PaymentTypeDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PaymentTypeConverter {

    public PaymentType toEntity(PaymentTypeDto dto) {
        return PaymentType.builder().id(dto.getId())
                .typeName(dto.getTypeName())
                .build();
    }

    public List<PaymentType> toEntities(List<PaymentTypeDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public PaymentTypeDto toDto(PaymentType paymentType) {
        return PaymentTypeDto.builder().id(paymentType.getId())
                .typeName(paymentType.getTypeName())
                .build();
    }

    public List<PaymentTypeDto> toDtos(List<PaymentType> paymentTypes) {
        return paymentTypes.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<PaymentTypeDto> toDtosPage(Page<PaymentType> paymentTypesPage) {
        return paymentTypesPage.map(this::toDto);
    }

    public Stream<PaymentTypeDto> toDtosStream(Stream<PaymentType> paymentTypesStream) {
        return paymentTypesStream.map(this::toDto);
    }

}
