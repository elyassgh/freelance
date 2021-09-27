package freelance.platform.api.bean.proposal;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.freelancer.Freelancer;
import freelance.platform.api.bean.job.Job;
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
@Table(name = "proposals")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Proposal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proposal_id")
    private Long id;

    @Column(name = "proposal_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime proposalTime;

    @Column(name = "client_grade")
    private String clientGrade;

    @Column(name = "client_comment", length = 512)
    private String clientComment;

    @Column(name = "freelancer_grade")
    private String freelancerGrade;

    @Column(name = "freelancer_comment", length = 512)
    private String freelancerComment;

    @Column(name = "payment_amount", nullable = false)
    private Double paymentAmount;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentType paymentType;

}
