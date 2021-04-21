package freelance.platform.api.repository.proposal;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.proposal.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    
}
