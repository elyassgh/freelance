package freelance.platform.api.converter.client;

import freelance.platform.api.bean.client.Company;
import freelance.platform.api.dto.client.CompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CompanyConverter {

    public Company toEntity(CompanyDto dto) {
        return Company.builder().name(dto.getName())
                .build();
    }

    public List<Company> toEntities(List<CompanyDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }


    public CompanyDto toDto(Company company) {
        return CompanyDto.builder().name(company.getName())
                .build();
    }

    public List<CompanyDto> toDtos(List<Company> companies) {
        return companies.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<CompanyDto> toDtosPage(Page<Company> companiesPage) {
        return companiesPage.map(this::toDto);
    }

    public Stream<CompanyDto> toDtosStream(Stream<Company> companiesStream) {
        return companiesStream.map(this::toDto);
    }

}
