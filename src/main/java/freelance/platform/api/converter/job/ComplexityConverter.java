package freelance.platform.api.converter.job;

import freelance.platform.api.bean.job.Complexity;
import freelance.platform.api.dto.job.ComplexityDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ComplexityConverter {

    public Complexity toEntity(ComplexityDto dto) {
        return Complexity.builder().id(dto.getId())
                .complexityText(dto.getComplexityText())
                .build();
    }

    public List<Complexity> toEntities(List<ComplexityDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public ComplexityDto toDto(Complexity complexity) {
        return ComplexityDto.builder().id(complexity.getId())
                .complexityText(complexity.getComplexityText())
                .build();
    }

    public List<ComplexityDto> toDtos(List<Complexity> complexities) {
        return complexities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<ComplexityDto> toDtosPage(Page<Complexity> complexitiesPage) {
        return complexitiesPage.map(this::toDto);
    }
    public Stream<ComplexityDto> toDtosStream(Stream<Complexity> complexitiesStream) {
        return complexitiesStream.map(this::toDto);
    }
}
