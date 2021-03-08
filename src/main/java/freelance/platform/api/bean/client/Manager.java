package freelance.platform.api.bean.client;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import freelance.platform.api.bean.UserAccount;
import lombok.Data;

@Entity
@Data
@Table(name = "hire_managers")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "account_id")
    private UserAccount account;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
