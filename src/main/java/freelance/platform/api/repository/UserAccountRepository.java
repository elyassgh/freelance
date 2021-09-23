package freelance.platform.api.repository;

import freelance.platform.api.bean.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findByUserName(String userName);
    Optional<UserAccount> findByEmail(String email);

}
