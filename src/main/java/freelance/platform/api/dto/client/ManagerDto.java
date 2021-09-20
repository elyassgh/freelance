package freelance.platform.api.dto.client;

import freelance.platform.api.dto.UserAccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDto {

    private Long id;
    private UserAccountDto account;
    private String location;
    private CompanyDto company;
    private LocalDateTime registeredAt;

}
