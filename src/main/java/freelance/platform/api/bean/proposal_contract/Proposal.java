package freelance.platform.api.bean.proposal_contract;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.job_post.Job;
import lombok.Data;

@Entity
@Data
@Table(name = "proposals")
public class Proposal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "propsal_id")
    private Long id;

    @Column(name = "proposal_time", nullable = false)
    private LocalDateTime proposalTime;

    @Column(name = "client_grade")
    private String clientGrade;
    
    @Column(name = "client_comment", length = 512)
    private String clientComment;

    @Column(name = "freelancer_grade")
    private String freelancerGrade;
    
    @Column(name = "freelancer_comment", length = 512)
    private String freelancerComment;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false )
    private Job job;

    @ManyToOne
    @JoinColumn(name = "payement_type_id", nullable = false)
    private PaymentType paymentType;

    @Column(name = "payment_amount" , nullable = false)
    private Double paymentAmount;

}
