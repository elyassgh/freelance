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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.client.Company;
import freelance.platform.api.bean.freelancer.Freelancer;
import lombok.Data;

@Entity
@Data
@Table(name = "contracts")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name = "payement_type_id", nullable = false)
    private PaymentType paymentType;

    @Column(name = "payment_amount" , nullable = false)
    private Double paymentAmount;
    
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = true)
    private LocalDateTime endTime;

}
