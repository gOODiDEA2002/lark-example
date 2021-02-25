package lark.example.msg.handler.executor;

import lark.example.msg.contract.handler.OrderCreateHandler;
import lark.example.msg.contract.message.OrderMessage;
import lark.example.msg.handler.biz.TestBiz;
import lark.msg.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author Andy Yuan
 * @date 2020/10/30
 */
@Component
public class OrderCreateHandlerImpl extends OrderCreateHandler {
    Logger log = LoggerFactory.getLogger( OrderCreateHandlerImpl.class );

    @Autowired
    TestBiz testBiz;

    @Override
    protected void process(OrderMessage msg, Message raw ) {
        String result = testBiz.hello( msg.getUserId() );
        log.info( ">>> result:{}, orderId:{}, userId: {}, createTime:{}", result, msg.getOrderId(), msg.getUserId(), msg.getCreateTime() );
    }
}