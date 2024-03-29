package freelance.platform.api.converter;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.dto.SkillDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SkillConverter {

    public Skill toEntity(SkillDto dto) {
        return Skill.builder().id(dto.getId())
                .skillName(dto.getSkillName())
                .build();
    }

    public List<Skill> toEntities(List<SkillDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public SkillDto toDto(Skill skill) {
        return SkillDto.builder().id(skill.getId())
                .skillName(skill.getSkillName())
                .build();
    }

    public List<SkillDto> toDtos(List<Skill> skills) {
        return skills.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<SkillDto> toDtosPage(Page<Skill> skillsPage) {
        return skillsPage.map(this::toDto);
    }

    public Stream<SkillDto> toDtosStream(Stream<Skill> skillsStream) {
        return skillsStream.map(this::toDto);
    }
}
