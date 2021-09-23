package freelance.platform.api.bean.freelancer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "certifcations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certification implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String certificationLink;


}
