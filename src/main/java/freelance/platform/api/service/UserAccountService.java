package freelance.platform.api.service;

import freelance.platform.api.bean.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserAccountService {

    public UserAccount save(UserAccount account);
    public UserAccount update(int id, UserAccount account);

    public Optional<UserAccount> findByUserName(String userName);
    public Optional<UserAccount> findByEmail(String email);
    public Optional<UserAccount> findById(int id);
    public Page<UserAccount> findAll(Pageable pageable);

    public UserAccount delete(int id);

}
