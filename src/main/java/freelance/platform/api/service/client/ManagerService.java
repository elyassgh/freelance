package freelance.platform.api.service.client;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.dto.client.ManagerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface ManagerService {

    public ManagerDto save(ManagerDto dto);
    public ManagerDto update(long id, ManagerDto dto);

    public Stream<ManagerDto> findByCompany(Long companyId);
    public Stream<ManagerDto> findByLocation(String location);
    public ManagerDto findByAccount(Long userAccountId);
    public Optional<Manager> findById(long id);
    public Page<ManagerDto> findAll(Pageable pageable);

    public void delete(long id);
}
