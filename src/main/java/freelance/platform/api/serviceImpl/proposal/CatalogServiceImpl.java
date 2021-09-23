package freelance.platform.api.serviceImpl.proposal;

import freelance.platform.api.bean.proposal.Catalog;
import freelance.platform.api.converter.proposal.CatalogConverter;
import freelance.platform.api.dto.proposal.CatalogDto;
import freelance.platform.api.repository.proposal.CatalogRepository;
import freelance.platform.api.service.proposal.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogRepository repository;
    @Autowired
    CatalogConverter converter;

    @Override
    public CatalogDto save(CatalogDto dto) {
        Catalog catalog = converter.toEntity(dto);
        return converter.toDto(repository.save(catalog));
    }

    @Override
    public CatalogDto update(long id, CatalogDto dto) {
        Catalog catalog = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        catalog.setStatusName(dto.getStatusName());
        return converter.toDto(repository.save(catalog));
    }

    @Override
    public Optional<Catalog> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public CatalogDto findByIdDto(long id) {
        Catalog catalog = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(catalog);
    }

    @Override
    public List<CatalogDto> findAll() {
        return converter.toDtos(repository.findAll());
    }

    @Override
    public void delete(long id) {
        Catalog catalog = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(catalog);
    }
}
