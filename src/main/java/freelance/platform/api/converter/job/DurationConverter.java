package freelance.platform.api.converter.job;

import freelance.platform.api.bean.job.Duration;
import freelance.platform.api.dto.job.DurationDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DurationConverter {

    public Duration toEntity(DurationDto dto) {
        return Duration.builder().id(dto.getId())
                .durationText(dto.getDurationText())
                .build();
    }

    public List<Duration> toEntities(List<DurationDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public DurationDto toDto(Duration duration) {
        return DurationDto.builder().id(duration.getId())
                .durationText(duration.getDurationText())
                .build();
    }

    public List<DurationDto> toDtos(List<Duration> durations) {
        return durations.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<DurationDto> toDtosPage(Page<Duration> durationsPage) {
        return durationsPage.map(this::toDto);
    }
    public Stream<DurationDto> toDtosStream(Stream<Duration> durationsStream) {
        return durationsStream.map(this::toDto);
    }

}
