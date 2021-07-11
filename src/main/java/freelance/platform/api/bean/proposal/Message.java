package freelance.platform.api.bean.proposal;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import freelance.platform.api.bean.client.Manager;
import freelance.platform.api.bean.freelancer.Freelancer;
import lombok.Data;

@Entity
@Data
@Table(name = "messages")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "message_time", nullable = false)
    private LocalDateTime messageTime;

    @Column(name = "message_text", nullable = false)
    private String messageText;

    @OneToMany(mappedBy = "message")
    private List<Attachment> attachments;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelance;

    @ManyToOne
    @JoinColumn(name = "hire_manager_id")
    private Manager manager;

}
