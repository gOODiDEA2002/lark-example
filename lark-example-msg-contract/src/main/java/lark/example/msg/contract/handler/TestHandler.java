package lark.example.msg.contract.handler;

import lark.example.msg.contract.dto.TestMessage;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * Created by Andy Yuan on 2020/10/30.
 */
public abstract class TestHandler implements RocketMQListener<TestMessage> {

    @Override
    public abstract void onMessage(TestMessage orderMsg );
}
