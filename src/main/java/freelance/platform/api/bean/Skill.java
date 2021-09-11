package freelance.platform.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import freelance.platform.api.bean.freelancer.Freelancer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills_dict")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
    private Long id;

    @Column(name = "skill_name", unique = true , nullable = false)
    private String skillName;

    @JsonIgnore
    @ManyToMany(mappedBy = "skills")
    private List<Freelancer> freelancers;

    public Skill(String skillName) {
        this.skillName = skillName;
        this.freelancers = new ArrayList<Freelancer>();
    }

}
