package freelance.platform.api.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment_types_dict")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_id")
    private Long id;

    @Column(name = "type_name" , nullable = false, unique = true)
    private String typeName;

}
