package freelance.platform.api.dto.freelancer;

import freelance.platform.api.bean.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerDto {

    private Long id;
    private UserAccount account;
    private LocalDate registrationDate;
    private String location;
    private String bio;

}
