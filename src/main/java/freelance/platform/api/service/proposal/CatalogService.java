package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.proposal.Catalog;
import freelance.platform.api.dto.proposal.CatalogDto;

import java.util.List;
import java.util.Optional;

public interface CatalogService {

    public CatalogDto save(CatalogDto dto);
    public CatalogDto update(long id, CatalogDto dto);

    public Optional<Catalog> findById(long id);
    public CatalogDto findByIdDto(long id);
    public List<CatalogDto> findAll();

    public void delete(long id);

}
