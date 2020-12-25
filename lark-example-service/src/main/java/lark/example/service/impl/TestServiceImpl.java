package lark.example.service.impl;

import lark.core.util.Times;
import lark.example.service.biz.OrderBiz;
import lark.example.service.biz.TestBiz;
import lark.example.service.contract.dto.GetOrderDto;
import lark.example.service.contract.dto.TestDto;
import lark.example.service.contract.constant.TestType;
import lark.example.service.entity.Order;
import lark.example.service.entity.TestObject;
import lark.example.service.contract.iface.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

/**
 * @author andy
 */
@Service("测试服务")
public class TestServiceImpl implements TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger( TestServiceImpl.class );
    @Autowired
    private TestBiz testBiz;

    @Autowired
    private OrderBiz orderBiz;

    @Override
    public TestDto.HelloResponse hello(TestDto.HelloRequest request) {
        TestObject object = testBiz.getObject(request.getId());
        TestDto.HelloResponse response = new TestDto.HelloResponse();
        response.setTime(Times.toEpochMilli( LocalDateTime.now().minusDays(-1) ) );
        response.setType(TestType.GOOD);
        response.setResult(object.getName());
        return response;
    }

    @Override
    public GetOrderDto.GetOrderResponse getOrder(GetOrderDto.GetOrderRequest request) {
        GetOrderDto.GetOrderResponse response = new GetOrderDto.GetOrderResponse();
        //
        long orderId = request.getOrderId();
        LOGGER.info( "request-> orderId:{}", orderId );
        Order order = orderBiz.getOrder( orderId );
        if ( order != null ) {
            LOGGER.info( "response-> orderId:{}, userId:{}, skuId:{}", order.getOrderId(), order.getUserId(), order.getSkuId() );
            response.setOrderId( order.getOrderId() );
            response.setUserId( order.getUserId() );
            response.setSkuId( order.getSkuId() );
        } else {
            LOGGER.info( "response-> order not found" );
        }
        return response;
    }
}