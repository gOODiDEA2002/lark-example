package lark.example.msg.handler.biz;

import lark.example.service.contract.constant.TestType;
import lark.example.service.contract.dto.TestDto;
import lark.example.service.contract.iface.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andy Yuan on 2020/11/9.
 */
@Component
public class TestBiz {
    @Autowired
    TestService testService;

    public String hello( int userId ) {
        TestDto.HelloRequest helloRequest = new TestDto.HelloRequest();
        helloRequest.setId( userId );
        helloRequest.setType( TestType.GOOD );
        TestDto.HelloResponse helloResponse = testService.hello( helloRequest );
        return helloResponse.getResult();
    }
}
