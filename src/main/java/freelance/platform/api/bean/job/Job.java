package freelance.platform.api.bean.job;

import freelance.platform.api.bean.PaymentType;
import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.proposal.Proposal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "jobs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentType paymentType;

    @Column(name = "payment_amount")
    private Double paymentAmount;

    @OneToOne
    @JoinColumn(name = "main_skill")
    private Skill skill;

    @ManyToMany
    @JoinTable(name = "other_skills",
            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"))
    private List<Skill> otherSkills;


    @OneToMany(mappedBy = "job", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Proposal> proposals;

}
