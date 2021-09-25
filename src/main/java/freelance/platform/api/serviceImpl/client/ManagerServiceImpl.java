package freelance.platform.api.serviceImpl.client;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.client.Company;
import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.converter.client.ManagerConverter;
import freelance.platform.api.dto.client.ManagerDto;
import freelance.platform.api.repository.client.ManagerRepository;
import freelance.platform.api.service.UserAccountService;
import freelance.platform.api.service.client.CompanyService;
import freelance.platform.api.service.client.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository repository;
    @Autowired
    ManagerConverter converter;
    @Autowired
    CompanyService companyService;
    @Autowired
    UserAccountService userAccountService;

    @Override
    public ManagerDto save(ManagerDto dto) {
        Company company = companyService.findById(dto.getCompany().getId()).orElseThrow(() -> new RuntimeException("not found"));
        Manager manager = converter.toEntity(dto);
        manager.setCompany(company);
        UserAccount account = userAccountService.save(dto.getAccount());
        manager.setAccount(account);
        return converter.toDto(repository.save(manager));
    }

    @Override
    public ManagerDto update(long id, ManagerDto dto) {
        Manager manager = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        manager.setLocation(dto.getLocation());
        return converter.toDto(repository.save(manager));
    }

    @Override
    public Stream<ManagerDto> findByCompany(Long companyId) {
        Company company = companyService.findById(companyId).orElseThrow(() -> new RuntimeException("not found"));
        Stream<Manager> managers = repository.findByCompany(company);
        return converter.toDtosStream(managers);
    }

    @Override
    public Stream<ManagerDto> findByLocation(String location) {
        Stream<Manager> managers = repository.findByLocationContains(location);
        return converter.toDtosStream(managers);
    }

    @Override
    public ManagerDto findByAccount(Long userAccountId) {
        UserAccount userAccount = userAccountService.findById(userAccountId).orElseThrow(() -> new RuntimeException("not found"));
        Manager manager = repository.findByAccount(userAccount);
        return converter.toDto(manager);
    }

    @Override
    public Optional<Manager> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public ManagerDto findByIdDto(long id) {
        Manager manager = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(manager);
    }

    @Override
    public Page<ManagerDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Manager manager = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        userAccountService.delete(manager.getId());
        //repository.delete(manager);
    }
}
