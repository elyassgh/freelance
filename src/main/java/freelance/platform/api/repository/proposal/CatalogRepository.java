package freelance.platform.api.repository.proposal;

import freelance.platform.api.bean.proposal.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    
}
