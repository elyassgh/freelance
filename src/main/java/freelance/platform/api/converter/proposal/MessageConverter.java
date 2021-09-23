package freelance.platform.api.converter.proposal;

import freelance.platform.api.bean.proposal.Message;
import freelance.platform.api.converter.client.ManagerConverter;
import freelance.platform.api.converter.freelancer.FreelancerConverter;
import freelance.platform.api.dto.proposal.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MessageConverter {

    @Autowired
    ManagerConverter managerConverter;
    @Autowired
    FreelancerConverter freelancerConverter;

    public Message toEntity(MessageDto dto) {
        return Message.builder().id(dto.getId())
                .messageText(dto.getMessageText())
                .build();
    }

    public List<Message> toEntities(List<MessageDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public MessageDto toDto(Message message) {
        return MessageDto.builder().id(message.getId())
                .messageText(message.getMessageText())
                .messageTime(message.getMessageTime())
                .manager(managerConverter.toDto(message.getManager()))
                .freelance(freelancerConverter.toDto(message.getFreelancer()))
                .build();
    }

    public List<MessageDto> toDtos(List<Message> messages) {
        return messages.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Page<MessageDto> toDtosPage(Page<Message> messagesPage) {
        return messagesPage.map(this::toDto);
    }

    public Stream<MessageDto> toDtosStream(Stream<Message> messagesStream) {
        return messagesStream.map(this::toDto);
    }

}
