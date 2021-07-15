package freelance.platform.api.service.proposal;

import freelance.platform.api.bean.proposal.Attachment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AttachmentService {

    public Attachment save(Attachment attachment);
    public Attachment update(int id, Attachment attachment);

    public Optional<Attachment> findById(int id);
    public Page<Attachment> findAll(Pageable pageable);

    public Attachment delete(int id);

}
