package freelance.platform.api.bean.job;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.proposal.Proposal;
import lombok.Data;

@Entity
@Data
@Table(name = "jobs")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private Long id;

    @Column(nullable = false, length = 1024)
    private String description;

    @OneToOne
    @JoinColumn(name = "hire_manger_id")
    private Manager manager;

    @OneToOne
    @JoinColumn(name = "complexity_id")
    private Complexity complexity;

    @OneToOne
    @JoinColumn(name = "duration_id")
    private Duration duration;

    @ManyToOne
    @JoinColumn(name = "payement_type_id" , nullable = false)
    private PaymentType paymentType;

    @Column(name = "payment_amount" , nullable = false)
    private Double paymentAmount;

    @OneToOne
    @JoinColumn(name = "main_skill")
    private Skill skill;

    @OneToMany
    @JoinTable(name = "other_skills" ,
        joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "job_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id" , referencedColumnName = "skill_id"))
    private List<Skill> otherSkills;

    @OneToMany(mappedBy = "job")
    private List<Proposal> propasals;

}
