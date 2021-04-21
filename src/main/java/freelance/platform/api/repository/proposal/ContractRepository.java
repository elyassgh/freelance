package freelance.platform.api.repository.proposal;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.platform.api.bean.proposal.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
