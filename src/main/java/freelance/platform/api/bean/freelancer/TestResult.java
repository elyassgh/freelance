package freelance.platform.api.bean.freelancer;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "Results")
public class TestResult implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_result_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = true)
    private LocalDateTime endTime;

    // URLs over 2,000 characters will not work in the most web browsers
    @Column(length = 2000)
    private String testResultLink;

    @Column(updatable = false)
    private Double score;

    @Column(nullable = false)
    private Boolean dispalyOnProfile;

    public TestResult(Freelancer freelancer, Test test, LocalDateTime startTime, LocalDateTime endTime,
            String testResultLink, Double score, Boolean dispalyOnProfile) {
        this.freelancer = freelancer;
        this.test = test;
        this.startTime = startTime;
        this.endTime = endTime;
        this.testResultLink = testResultLink;
        this.score = score;
        this.dispalyOnProfile = dispalyOnProfile;
    }

}
