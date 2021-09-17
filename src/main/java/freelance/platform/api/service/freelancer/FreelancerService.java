package freelance.platform.api.service.freelancer;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.freelancer.Certification;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.dto.freelancer.FreelancerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Stream;

public interface FreelancerService {

    public FreelancerDto save(FreelancerDto dto);
    public FreelancerDto update(long id, FreelancerDto dto);

    public FreelancerDto findByAccount(long accountId);
    public Stream<FreelancerDto> findByLocation(String location);
    public Stream<FreelancerDto> findByBioContains(String keyword);
    public Optional<Freelancer> findById(long id);
    public FreelancerDto findByIdDto(long id);
    public Page<FreelancerDto> findAll(Pageable pageable);

    public void delete(long id);

}
