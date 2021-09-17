package freelance.platform.api.dto.freelancer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificationDto {

    private Long id;
    private String certificationName;
    private String certificationProvider;
    private String description;
    private LocalDate dateEarned;
    private String certificationLink;

}
