package freelance.platform.api.bean.freelancer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import freelance.platform.api.bean.Skill;
import freelance.platform.api.bean.UserAccount;
import freelance.platform.api.bean.proposal.Contract;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "freelancers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Freelancer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "freelancer_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private UserAccount account;

    @Column(name = "registration_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate registrationDate;

    // County (Ex : Morocco)
    @Column(nullable = false)
    private String location;

    @Column(length = 512)
    private String bio;

    @OneToMany(mappedBy = "freelancer")
    private List<Certification> certifications;

    @ManyToMany
    @JoinTable(name = "has_skill",
        joinColumns = @JoinColumn(name = "freelancer_id" , referencedColumnName = "freelancer_id" ),
        inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"))
    private List<Skill> skills;

    @OneToMany(mappedBy = "freelancer")
    private List<Contract> contracts;
    
}