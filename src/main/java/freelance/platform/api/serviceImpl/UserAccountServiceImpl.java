package freelance.platform.api.serviceImpl;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.converter.UserAccountConverter;
import freelance.platform.api.dto.UserAccountDto;
import freelance.platform.api.repository.UserAccountRepository;
import freelance.platform.api.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepository repository;
    @Autowired
    UserAccountConverter converter;

    @Override
    public UserAccountDto save(UserAccountDto dto) {
        UserAccount userAccount = converter.toEntity(dto);
        return converter.toDto(repository.save(userAccount));
    }

    @Override
    public UserAccountDto update(long id, UserAccountDto dto) {
        UserAccount userAccount = this.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        userAccount.setEmail(dto.getEmail());
        userAccount.setUserName(dto.getUserName());
        userAccount.setFirstName(dto.getFirstName());
        userAccount.setLastName(dto.getLastName());
        userAccount.setPassword(dto.getPassword());
        return converter.toDto(repository.save(userAccount));
    }

    @Override
    public UserAccountDto findByUserName(String userName) {
        UserAccount userAccount = repository.findByUserName(userName).orElseThrow(()-> new RuntimeException("not found !"));
        return converter.toDto(userAccount);
    }

    @Override
    public UserAccountDto findByEmail(String email) {
        UserAccount userAccount = repository.findByEmail(email).orElseThrow(()-> new RuntimeException("not found !"));
        return converter.toDto(userAccount);
    }

    @Override
    public Optional<UserAccount> findById(long id) {
       return repository.findById(id);
    }

    @Override
    public Page<UserAccountDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        UserAccount userAccount = this.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(userAccount);
    }
}
