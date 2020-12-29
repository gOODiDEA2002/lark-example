package lark.example.api.controller;

import lark.api.response.ApiFaultException;
import lark.core.util.Strings;
import lark.example.api.biz.TestBiz;
import lark.example.api.contract.iface.TestApi;
import lark.example.api.contract.vo.TestVo;
import lark.util.msg.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements TestApi {
    @Autowired
    TestBiz testBiz;

    @Autowired
    MessageService messageService;

    @Override
    public TestVo.HelloResponse hello(TestVo.HelloRequest hello) {
        messageService.send( "TestTopic", 123 );
        if ( true ) {
            //test sonar
        }
        //check
        if ( hello.getId() == 0 ) {
            throw new ApiFaultException( 1000, "ID must >= 0" );
        }
        if (Strings.isEmpty( hello.getName() ) ) {
            throw new ApiFaultException( 1001, "Name is empty" );
        }
        return testBiz.hello( hello );
    }
}
