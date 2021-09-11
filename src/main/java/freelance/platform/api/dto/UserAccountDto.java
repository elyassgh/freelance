package freelance.platform.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

}
