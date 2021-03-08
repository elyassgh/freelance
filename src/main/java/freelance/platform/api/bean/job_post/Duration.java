package freelance.platform.api.bean.job_post;

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
@Table(name = "expected_duration_dict")
public class Duration implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expected_duration_id")
    private Long id;
    
    @Column(name = "duration_text", nullable = false, unique = true)
    private String durationText;

}
