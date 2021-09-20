package freelance.platform.api.serviceImpl.freelancer;

import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.converter.freelancer.FreelancerConverter;
import freelance.platform.api.dto.SkillDto;
import freelance.platform.api.dto.freelancer.FreelancerDto;
import freelance.platform.api.repository.freelancer.FreelancerRepository;
import freelance.platform.api.service.SkillService;
import freelance.platform.api.service.UserAccountService;
import freelance.platform.api.service.freelancer.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FreelancerServiceImpl implements FreelancerService {

    @Autowired
    FreelancerRepository repository;
    @Autowired
    FreelancerConverter converter;
    @Autowired
    UserAccountService accountService;
    @Autowired
    SkillService skillService;

    @Override
    public FreelancerDto save(FreelancerDto dto) {
        UserAccount userAccount = accountService.findById(dto.getAccount().getId()).orElseThrow(() -> new RuntimeException("not found"));
        Freelancer freelancer = converter.toEntity(dto);
        freelancer.setAccount(userAccount);
        return converter.toDto(repository.save(freelancer));
    }

    @Override
    public FreelancerDto update(long id, FreelancerDto dto) {
        Freelancer freelancer = repository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        if(dto.getLocation() != null) freelancer.setLocation(dto.getLocation());
        if(dto.getBio() != null) freelancer.setBio(dto.getBio());
        return converter.toDto(repository.save(freelancer));
    }

    @Override
    public FreelancerDto findByAccount(long accountId) {
        UserAccount userAccount = accountService.findById(accountId).orElseThrow(() -> new RuntimeException("not found"));
        return converter.toDto(repository.findByAccount(userAccount));
    }

    @Override
    public Stream<FreelancerDto> findByLocation(String location) {
        return converter.toDtosStream(repository.findByLocation(location));
    }

    @Override
    public Stream<FreelancerDto> findByBioContains(String keyword) {
        return converter.toDtosStream(repository.findByBioContains(keyword));
    }

    @Override
    public Optional<Freelancer> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public FreelancerDto findByIdDto(long id) {
        Freelancer freelancer = repository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        return converter.toDto(freelancer);
    }

    @Override
    public Page<FreelancerDto> findAll(Pageable pageable) {
        return converter.toDtosPage(repository.findAll(pageable));
    }

    @Override
    public void delete(long id) {
        Freelancer freelancer = repository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        repository.delete(freelancer);
    }
}
