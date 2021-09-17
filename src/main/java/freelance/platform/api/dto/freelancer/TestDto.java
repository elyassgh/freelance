package freelance.platform.api.dto.freelancer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private Long id;
    private String testName;
    private String testLink;

}
