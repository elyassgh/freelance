package freelance.platform.api.bean.client;

import freelance.platform.api.bean.proposal.Contract;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Manager> managers;

    @OneToMany(mappedBy = "company")
    private List<Contract> contracts;

}
