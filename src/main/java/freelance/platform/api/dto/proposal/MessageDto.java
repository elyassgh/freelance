package freelance.platform.api.dto.proposal;

import freelance.platform.api.dto.client.ManagerDto;
import freelance.platform.api.dto.freelancer.FreelancerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private Long id;
    private LocalDateTime messageTime;
    private String messageText;
    private FreelancerDto freelance;
    private ManagerDto manager;

}
