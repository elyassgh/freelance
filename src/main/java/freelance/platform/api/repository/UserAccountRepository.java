package freelance.platform.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {


    
}
