package lark.example.api.biz;

import lark.example.api.contract.vo.TestVo;
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

    public TestVo.HelloResponse hello( TestVo.HelloRequest request ) {
        TestDto.HelloRequest helloRequest = new TestDto.HelloRequest();
        helloRequest.setId( request.getId() );
        helloRequest.setType( TestType.GOOD );
        TestDto.HelloResponse helloResponse = testService.hello( helloRequest );
        //
        TestVo.HelloResponse response = new TestVo.HelloResponse();
        response.setResult( helloResponse.getResult() );
        response.setTime( helloResponse.getTime() );
        return response;
    }
}
