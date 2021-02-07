package lark.example.msg.contract.handler;

import lark.example.msg.contract.message.OrderMessage;
import lark.example.msg.contract.topic.OrderTopic;
import lark.msg.AbstractHandler;
import lark.msg.MsgHandler;

/**
 *
 * @author Andy Yuan
 * @date 2020/10/30
 */
@MsgHandler(topic = OrderTopic.ORDER_CREATE_TOPIC, threads = 2)
public abstract class OrderCreateHandler extends AbstractHandler<OrderMessage> {

}
