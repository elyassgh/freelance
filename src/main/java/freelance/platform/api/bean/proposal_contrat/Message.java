package freelance.platform.api.bean.proposal_contrat;


import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "messages")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "message_time", nullable = false)
    private Instant messageTime;


    @Column(name = "message_text", nullable = false)
    private String messageText;

    @OneToMany(mappedBy = "message")
    private List<Attachement> attachements;
}
