package freelance.platform.api.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_types_dict")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_type_id")
    private Long id;

    @Column(name = "type_name" , nullable = false, unique = true)
    private String typeName;

}
