package freelance.platform.api.converter.client;

import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.converter.UserAccountConverter;
import freelance.platform.api.dto.client.ManagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ManagerConverter {

    @Autowired
    CompanyConverter companyConverter;
    @Autowired
    UserAccountConverter userAccountConverter;

    public Manager toEntity(ManagerDto dto) {
        return Manager.builder().id(dto.getId())
                .location(dto.getLocation())
                .registeredAt(dto.getRegisteredAt())
                .build();
    }

    public List<Manager> toEntities(List<ManagerDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public ManagerDto toDto(Manager manager) {
        return ManagerDto.builder().id(manager.getId())
                .account(userAccountConverter.toDto(manager.getAccount()))
                .location(manager.getLocation())
                .company(companyConverter.toDto(manager.getCompany()))
                .registeredAt(manager.getRegisteredAt())
                .build();
    }

    public List<ManagerDto> toDtos(List<Manager> managers) {
        return managers.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<ManagerDto> toDtosPage(Page<Manager> managersPage) {
        return managersPage.map(this::toDto);
    }

    public Stream<ManagerDto> toDtosStream(Stream<Manager> managersStream) {
        return managersStream.map(this::toDto);
    }

}
