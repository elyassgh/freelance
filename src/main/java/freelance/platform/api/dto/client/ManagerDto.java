package freelance.platform.api.dto.client;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.client.Company;
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
    private UserAccount account;
    private String location;
    private Company company;
    private LocalDateTime registeredAt;

}
