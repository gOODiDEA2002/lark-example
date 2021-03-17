package lark.example.service.impl;

import lark.core.util.Times;
import lark.example.service.biz.OrderBiz;
import lark.example.service.biz.TestBiz;
import lark.example.service.contract.constant.TestType;
import lark.example.service.contract.dto.GetOrderDto;
import lark.example.service.contract.dto.TestDto;
import lark.example.service.contract.iface.Test2Service;
import lark.example.service.contract.iface.TestService;
import lark.example.service.entity.OrderDO;
import lark.example.service.entity.TestDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author andy
 */
@Service("测试服务2")
public class Test2ServiceImpl implements Test2Service {
    private static final Logger LOGGER = LoggerFactory.getLogger( Test2ServiceImpl.class );
    @Autowired
    private TestBiz testBiz;

    @Override
    public TestDto.HelloResponse hello2(TestDto.HelloRequest request) {
        TestDO object = testBiz.getObject(request.getId());
        TestDto.HelloResponse response = new TestDto.HelloResponse();
        response.setTime(Times.toEpochMilli( LocalDateTime.now().minusDays(-1) ) );
        response.setType(TestType.GOOD);
        response.setResult(object.getName());
        //
        return response;
    }
}