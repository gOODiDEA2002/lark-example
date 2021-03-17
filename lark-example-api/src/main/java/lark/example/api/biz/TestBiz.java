package lark.example.api.biz;

import lark.example.api.contract.vo.TestVo;
import lark.example.service.contract.ExampleServiceManager;
import lark.example.service.contract.constant.TestType;
import lark.example.service.contract.dto.TestDto;
import lark.example.service.contract.iface.Test2Service;
import lark.example.service.contract.iface.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andy Yuan on 2020/11/9.
 */
@Component
public class TestBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBiz.class);

    @Autowired
    TestService testService;

    @Autowired
    ExampleServiceManager serviceManager;

    public TestVo.HelloResponse hello( TestVo.HelloRequest request ) {
        TestDto.HelloRequest helloRequest = new TestDto.HelloRequest();
        helloRequest.setId( request.getId() );
        helloRequest.setType( TestType.GOOD );
        TestDto.HelloResponse helloResponse = testService.hello( helloRequest );
        //
        Test2Service test2Service = serviceManager.getService( Test2Service.class );
        TestDto.HelloResponse helloResponse2 = test2Service.hello2( helloRequest );
        if ( !helloResponse.getResult().equals( helloResponse2.getResult() )) {
            LOGGER.info( "hello: {}", helloResponse.getResult());
            LOGGER.info( "hello2: {}", helloResponse2.getResult());
        }
        //
        TestVo.HelloResponse response = new TestVo.HelloResponse();
        response.setResult( helloResponse.getResult() );
        response.setTime( helloResponse.getTime() );

        return response;
    }
}
