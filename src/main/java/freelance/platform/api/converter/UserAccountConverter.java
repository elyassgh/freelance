package freelance.platform.api.converter;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.dto.UserAccountDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAccountConverter {

    public UserAccount toEntity(UserAccountDto dto) {
        return UserAccount.builder().id(dto.getId())
                .userName(dto.getUserName())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .createdDate(dto.getCreatedDate())
                .modifiedDate(dto.getModifiedDate())
                .build();
    }

    public List<UserAccount> toEntities(List<UserAccountDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public UserAccountDto toDto(UserAccount userAccount) {
        return UserAccountDto.builder().id(userAccount.getId())
                .userName(userAccount.getUserName())
                .firstName(userAccount.getFirstName())
                .lastName(userAccount.getLastName())
                .email(userAccount.getEmail())
                .password(userAccount.getPassword())
                .createdDate(userAccount.getCreatedDate())
                .modifiedDate(userAccount.getModifiedDate())
                .build();
    }

    public List<UserAccountDto> toDtos(List<UserAccount> userAccounts) {
        return userAccounts.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<UserAccountDto> toDtosPage(Page<UserAccount> userAccountsPage) {
        return userAccountsPage.map(this::toDto);
    }

}
