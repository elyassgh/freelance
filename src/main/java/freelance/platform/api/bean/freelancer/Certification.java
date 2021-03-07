package freelance.platform.api.bean.freelancer;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "certifcations")
public class Certification implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "certification_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="freelancer_id")
    private Freelancer freelancer;

    @Column(name = "certification_name", nullable = false)
    private String certificationName;
    
    @Column(name = "certification_provider", nullable = false)
    private String certificationProvider;

    @Column(name = "description", nullable = false, length = 1024)
    private String description;
    
    @Column(nullable = false)
    private LocalDate dateEarned;
    
    // URLs over 2,000 characters will not work in the most web browsers
    @Column(length = 2000)
    private String certifactionLink;


    public Certification(Freelancer freelancer, String certificationName, String certificationProvider,
            String description, LocalDate dateEarned, String certifactionLink) {
        this.freelancer = freelancer;
        this.certificationName = certificationName;
        this.certificationProvider = certificationProvider;
        this.description = description;
        this.dateEarned = dateEarned;
        this.certifactionLink = certifactionLink;
    }

}
