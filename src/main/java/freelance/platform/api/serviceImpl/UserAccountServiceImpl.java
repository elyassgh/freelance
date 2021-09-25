package freelance.platform.api.serviceImpl;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.converter.UserAccountConverter;
import freelance.platform.api.dto.UserAccountDto;
import freelance.platform.api.repository.UserAccountRepository;
import freelance.platform.api.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepository repository;
    @Autowired
    UserAccountConverter converter;

    @Override
    public UserAccount save(UserAccountDto dto) {
        log.info("save userAccount service Impl");
        UserAccount userAccount = converter.toEntity(dto);
        return repository.save(userAccount);
    }

    @Override
    public UserAccountDto update(long id, UserAccountDto dto) {
        log.info("update userAccount service Impl");
        log.info("dto data : {} ", dto.toString());
        UserAccount userAccount = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        if (dto.getEmail() != null) userAccount.setEmail(dto.getEmail());
        if (dto.getUserName() != null) userAccount.setUserName(dto.getUserName());
        if (dto.getFirstName() != null) userAccount.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) userAccount.setLastName(dto.getLastName());
        if (dto.getPassword() != null) userAccount.setPassword(dto.getPassword());
        return converter.toDto(repository.save(userAccount));
    }

    @Override
    public UserAccountDto findByUserName(String userName) {
        log.info("findByUserName userAccount service Impl");
        UserAccount userAccount = repository.findByUserName(userName).orElseThrow(() -> new RuntimeException("not found !"));
        return converter.toDto(userAccount);
    }

    @Override
    public UserAccountDto findByEmail(String email) {
        log.info("findByEmail userAccount service Impl");
        UserAccount userAccount = repository.findByEmail(email).orElseThrow(() -> new RuntimeException("not found !"));
        return converter.toDto(userAccount);
    }

    // for internal use ( other services )
    @Override
    public Optional<UserAccount> findById(long id) {
        log.info("findById userAccount service Impl");
        return repository.findById(id);
    }

    // for external use ( api end points and so)
    @Override
    public UserAccountDto findByIdDto(long id) {
        log.info("findByIdDto userAccount service Impl");
        UserAccount userAccount = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(userAccount);
    }

    @Override
    public Page<UserAccountDto> findAll(Pageable pageable) {
        log.info("findAll userAccount service Impl");
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        UserAccount userAccount = findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(userAccount);
    }
}
