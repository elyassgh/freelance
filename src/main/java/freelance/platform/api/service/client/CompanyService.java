package freelance.platform.api.service.client;

import freelance.platform.api.bean.client.Company;
import freelance.platform.api.dto.client.CompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CompanyService {

    public CompanyDto save(CompanyDto dto);
    public CompanyDto update(long id, CompanyDto dto);

    public CompanyDto findByName(String name);
    public Optional<Company> findById(long id);
    public CompanyDto findByIdDto(long id);
    public Page<CompanyDto> findAll(Pageable pageable);

    public void delete(long id);

}
