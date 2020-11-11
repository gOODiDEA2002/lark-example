package lark.example.api.controller;

import lark.api.response.ApiFaultException;
import lark.core.util.Strings;
import lark.example.api.biz.TestBiz;
import lark.example.api.contract.iface.TestApi;
import lark.example.api.contract.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements TestApi {
    @Autowired
    TestBiz testBiz;

    @Override
    public TestVo.HelloResponse hello(TestVo.HelloRequest hello) {
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
