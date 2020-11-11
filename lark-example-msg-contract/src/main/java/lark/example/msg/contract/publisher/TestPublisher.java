package lark.example.msg.contract.publisher;

import lark.example.msg.contract.dto.TestMessage;
import lark.example.msg.contract.topic.TestTopic;
import lark.util.msg.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andy Yuan on 2020/10/30.
 */
@Component
public class TestPublisher {

    @Autowired
    MessageService messageService;

    public boolean createOrder(TestMessage orderMsg ) {
        return messageService.send( TestTopic.CREATE_ORDER, orderMsg );
    }

}
