package lark.example.service.impl;

import lark.core.util.Times;
import lark.example.service.biz.TestBiz;
import lark.example.service.contract.dto.TestDto;
import lark.example.service.contract.constant.TestType;
import lark.example.service.entity.TestObject;
import lark.example.service.contract.iface.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service("测试服务")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestBiz testBiz;

    @Override
    public TestDto.HelloResponse hello(TestDto.HelloRequest request) {
        TestObject object = testBiz.getObject(request.getId());
        TestDto.HelloResponse response = new TestDto.HelloResponse();
        response.setTime(Times.toEpochMilli( LocalDateTime.now().minusDays(-1) ) );
        response.setType(TestType.GOOD);
        response.setResult(object.getName());
        return response;
    }
}