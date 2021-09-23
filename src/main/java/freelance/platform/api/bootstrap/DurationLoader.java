package freelance.platform.api.bootstrap;

import freelance.platform.api.bean.job.Duration;
import freelance.platform.api.repository.job.DurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DurationLoader implements ApplicationRunner {

    @Autowired
    DurationRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Duration(null, "1 day"));
        repository.save(new Duration(null, "2-7 days"));
        repository.save(new Duration(null, "2 weeks"));
        repository.save(new Duration(null, "less than 1 month"));
        repository.save(new Duration(null, "1-3 months"));
        repository.save(new Duration(null, "3-6 months"));
        repository.save(new Duration(null, "6 or more months"));
    }
}
