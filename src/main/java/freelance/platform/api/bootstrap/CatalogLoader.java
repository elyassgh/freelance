package freelance.platform.api.bootstrap;

import freelance.platform.api.bean.proposal.Catalog;
import freelance.platform.api.repository.proposal.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CatalogLoader implements ApplicationRunner {

    @Autowired
    CatalogRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Catalog(null, "proposal sent"));
        repository.save(new Catalog(null, "negotiation phase"));
        repository.save(new Catalog(null, "proposal withdrawn"));
        repository.save(new Catalog(null, "proposal rejected"));
        repository.save(new Catalog(null, "proposal accepted"));
        repository.save(new Catalog(null, "job started"));
        repository.save(new Catalog(null, "job finished successfully"));
        repository.save(new Catalog(null, "job finished unsuccessfully"));
    }
}
