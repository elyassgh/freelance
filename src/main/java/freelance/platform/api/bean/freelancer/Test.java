package freelance.platform.api.bean.freelancer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tests")
public class Test implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "test_id")
    private Long id;
    
    @Column(nullable = false)
    private String testName;

    // URLs over 2,000 characters will not work in the most web browsers
    @Column(nullable = false , length = 2000)
    private String testLink;

    public Test(String testName, String testLink) {
        this.testName = testName;
        this.testLink = testLink;
    }
    
}
