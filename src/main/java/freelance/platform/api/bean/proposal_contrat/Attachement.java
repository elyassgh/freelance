package freelance.platform.api.bean.proposal_contrat;

import java.io.Serializable;

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
@Table(name = "attachements")
public class Attachement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attachement_id")
    private Long id;

    @Column(nullable = false, length = 2000)
    private String attachementLink;

    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    private Message message;


}
