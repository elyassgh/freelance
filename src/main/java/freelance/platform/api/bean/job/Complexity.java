package freelance.platform.api.bean.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "complexity_dict")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Complexity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "complexity_id")
    private Long id;

    @Column(name = "complexity_text", nullable = false, unique = true)
    private String complexityText;

}
