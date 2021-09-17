package freelance.platform.api.serviceImpl.client;

import freelance.platform.api.bean.client.Company;
import freelance.platform.api.converter.client.CompanyConverter;
import freelance.platform.api.dto.client.CompanyDto;
import freelance.platform.api.repository.client.CompanyRepository;
import freelance.platform.api.service.client.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository repository;
    @Autowired
    CompanyConverter converter;

    @Override
    public CompanyDto save(CompanyDto dto) {
        Company company = converter.toEntity(dto);
        return converter.toDto(repository.save(company));
    }

    @Override
    public CompanyDto update(long id, CompanyDto dto) {
        Company company = findById(id).orElseThrow(() -> new RuntimeException("not found !"));
        company.setName(dto.getName());
        return converter.toDto(repository.save(company));
    }

    @Override
    public CompanyDto findByName(String name) {
        Company company = repository.findByName(name).orElseThrow(() -> new RuntimeException("not found !"));
        return converter.toDto(repository.save(company));
    }

    @Override
    public Optional<Company> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public CompanyDto findByIdDto(long id) {
        Company company = findById(id).orElseThrow(() -> new RuntimeException("not found !"));
        return converter.toDto(company);
    }

    @Override
    public Page<CompanyDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Company company = findById(id).orElseThrow(() -> new RuntimeException("not found !"));
        repository.delete(company);
    }
}
