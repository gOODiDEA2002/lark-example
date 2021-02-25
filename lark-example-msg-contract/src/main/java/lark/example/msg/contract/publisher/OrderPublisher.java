package lark.example.msg.contract.publisher;

import lark.example.msg.contract.message.OrderMessage;
import lark.example.msg.contract.topic.OrderTopic;
import lark.msg.Publisher;

/**
 * Created by Andy Yuan on 2020/10/30.
 */
public class OrderPublisher {

    private Publisher publisher;

    public OrderPublisher( Publisher publisher ) {
        this.publisher = publisher;
    }

    public void orderCreate(OrderMessage orderMessage ) {
        publisher.publish(OrderTopic.ORDER_CREATE_TOPIC, orderMessage );
    }
}
