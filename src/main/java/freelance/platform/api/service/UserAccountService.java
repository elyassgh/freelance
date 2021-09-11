package freelance.platform.api.service;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.dto.UserAccountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserAccountService {

    public UserAccountDto save(UserAccountDto dto);
    public UserAccountDto update(long id, UserAccountDto dto);

    public UserAccountDto findByUserName(String userName);
    public UserAccountDto findByEmail(String email);
    public Optional<UserAccount> findById(long id);
    public Page<UserAccountDto> findAll(Pageable pageable);

    public void delete(long id);

}
