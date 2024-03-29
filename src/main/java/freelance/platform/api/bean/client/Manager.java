package freelance.platform.api.bean.client;

import freelance.platform.api.bean.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "hire_managers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "user_account_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_account_id")
    private UserAccount account;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @CreationTimestamp
    @Column(name = "registration_date")
    private LocalDateTime registeredAt;
}
