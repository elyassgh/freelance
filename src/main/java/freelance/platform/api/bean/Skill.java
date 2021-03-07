package freelance.platform.api.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import freelance.platform.api.bean.freelancer.Freelancer;
import lombok.Data;

@Entity
@Data
@Table(name = "skills")
public class Skill implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
    private Long id;

    @Column(name = "skill_name", unique = true , nullable = false)
    private String skillName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "skills")
    private List<Freelancer> freelancers;

    public Skill(String skillName) {
        this.skillName = skillName;
        this.freelancers = new ArrayList<Freelancer>();
    }

}
