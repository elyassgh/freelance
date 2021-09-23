package freelance.platform.api.bootstrap;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PaymentTypeLoader implements ApplicationRunner {

    @Autowired
    PaymentTypeRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new PaymentType(null, "Paypal"));
        repository.save(new PaymentType(null, "Bitcoin/Cryptocurrency"));
        repository.save(new PaymentType(null, "Check or similar"));
        repository.save(new PaymentType(null, "Mobile payment"));
        repository.save(new PaymentType(null, "Cash Transfer"));
        repository.save(new PaymentType(null, "Bank Transfer"));
    }
}
