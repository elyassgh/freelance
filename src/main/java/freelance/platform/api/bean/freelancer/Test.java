package freelance.platform.api.bean.freelancer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tests")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;
    
    @Column(nullable = false)
    private String testName;

    // URLs over 2,000 characters will not work in the most web browsers
    @Column(nullable = false , length = 2000)
    private String testLink;

}
