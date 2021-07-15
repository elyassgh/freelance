package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.proposal.Catalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CatalogService {

    public Catalog save(Catalog catalog);
    public Catalog update(int id, Catalog catalog);

    public Optional<Catalog> findById(int id);
    public Page<Catalog> findAll(Pageable pageable);

    public Catalog delete(int id);

}
