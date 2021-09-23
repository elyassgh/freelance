package freelance.platform.api.bean.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "expected_duration_dict")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Duration implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expected_duration_id")
    private Long id;
    
    @Column(name = "duration_text", nullable = false, unique = true)
    private String durationText;

}
