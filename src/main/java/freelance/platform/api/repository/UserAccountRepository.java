package freelance.platform.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import freelance.platform.api.bean.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUserName(String userName);

    UserAccount findByEmail(String email);

	List<UserAccount> findAll();

}
