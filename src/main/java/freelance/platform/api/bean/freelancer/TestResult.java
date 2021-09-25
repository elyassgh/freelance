package freelance.platform.api.bean.freelancer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Results")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResult implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_result_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    // URLs over 2,000 characters will not work in the most web browsers
    @Column(length = 2000)
    private String testResultLink;

    @Column(updatable = false)
    private Double score;

    @Column(nullable = false)
    private Boolean displayOnProfile;


}
