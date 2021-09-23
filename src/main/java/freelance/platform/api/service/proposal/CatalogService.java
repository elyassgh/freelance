package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.proposal.Catalog;
import freelance.platform.api.dto.proposal.CatalogDto;

import java.util.List;
import java.util.Optional;

public interface CatalogService {

    public CatalogDto save(CatalogDto catalog);
    public CatalogDto update(long id, CatalogDto catalog);

    public Optional<Catalog> findById(long id);
    public CatalogDto findByIdDto(long id);
    public List<Catalog> findAll();

    public void delete(long id);

}
