package freelance.platform.api.bean.client;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import freelance.platform.api.bean.proposal.Contract;
import lombok.Data;

@Entity
@Data
@Table(name = "companies")
public class Company implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "company_id")
   private Long id;

   @Column(name = "company_name")
   private String name;

   @JsonIgnore
   @OneToMany(mappedBy = "company")
   private List<Manager> managers;

   @JsonIgnore
   @OneToMany(mappedBy = "company")
   private List<Contract> contracts;

}
