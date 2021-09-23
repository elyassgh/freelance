package freelance.platform.api.bootstrap;

import freelance.platform.api.bean.job.Complexity;
import freelance.platform.api.repository.job.ComplexityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ComplexityLoader implements ApplicationRunner {

    @Autowired
    ComplexityRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Complexity(null,"easy"));
        repository.save(new Complexity(null,"intermediate"));
        repository.save(new Complexity(null,"hard"));
        repository.save(new Complexity(null,"professional"));
    }
}
