package freelance.platform.api.bean.freelancer;

import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.proposal.Contract;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "freelancers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Freelancer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_account_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_account_id")
    private UserAccount account;

    @Column(name = "registration_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime registrationDate;

    // County (Ex : Morocco)
    @Column(nullable = false)
    private String location;

    @Column(length = 512)
    private String bio;

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.REMOVE ,orphanRemoval = true)
    private List<Certification> certifications;

    @ManyToMany
    @JoinTable(name = "has_skill",
            joinColumns = @JoinColumn(name = "user_account_id", referencedColumnName = "user_account_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"))
    private List<Skill> skills;

    @OneToMany(mappedBy = "freelancer")
    private List<Contract> contracts;

}