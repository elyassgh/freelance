package freelance.platform.api.bean.proposal;


import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.freelancer.Freelancer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "message_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime messageTime;

    @Column(name = "message_text", nullable = false)
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name = "manager_account_id")
    private Manager manager;

}
