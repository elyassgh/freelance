package freelance.platform.api.converter.proposal;

import freelance.platform.api.bean.proposal.Catalog;
import freelance.platform.api.dto.proposal.CatalogDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CatalogConverter {

    public Catalog toEntity(CatalogDto dto) {
        return Catalog.builder().id(dto.getId())
                .statusName(dto.getStatusName())
                .build();
    }

    public List<Catalog> toEntities(List<CatalogDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public CatalogDto toDto(Catalog catalog) {
        return CatalogDto.builder().id(catalog.getId())
                .statusName(catalog.getStatusName())
                .build();
    }

    public List<CatalogDto> toDtos(List<Catalog> catalogs) {
        return catalogs.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<CatalogDto> toDtos(Page<Catalog> catalogsPage) {
        return catalogsPage.map(this::toDto);
    }

    public Stream<CatalogDto> toDtos(Stream<Catalog> catalogsStream) {
        return catalogsStream.map(this::toDto);
    }

}
