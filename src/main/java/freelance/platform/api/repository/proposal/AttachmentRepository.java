package freelance.platform.api.repository.proposal;

import freelance.platform.api.bean.proposal.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    
}
