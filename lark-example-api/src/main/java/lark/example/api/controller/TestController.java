package lark.example.api.controller;

import lark.api.response.ApiFaultException;
import lark.core.util.Strings;
import lark.example.api.biz.TestBiz;
import lark.example.api.contract.iface.TestApi;
import lark.example.api.contract.vo.TestVo;
import lark.example.api.index.UserDocument;
import lark.example.api.index.UserIndexService;
import lark.util.cache.CacheService;
import lark.util.cache.impl.RedisCacheService;
import lark.util.index.config.ElasticsearchConfig;
import lark.util.msg.MessageService;
import lark.util.oss.OssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.time.Duration;

@RestController
public class TestController implements TestApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestBiz testBiz;

    @Autowired
    MessageService messageService;

    @Autowired
    UserIndexService userIndexService;

    @Autowired
    OssService ossService;

    @Override
    public TestVo.HelloResponse hello(TestVo.HelloRequest hello) {
        String filepath = "/etc/certs/wx_cert.pem";
        File file = new File( filepath );
        try {
            try ( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file ))) ) {
                String data = null;
                while((data = br.readLine())!=null)
                {
                    System.out.println(data);
                }
            }
        } catch ( Exception e ) {
            LOGGER.info( e.getMessage() );
        }
//        try {
//            byte[] data = ossService.download("secret", "gugong/apiclient_key.pem");
//            String filepath = "~/Download/apiclient_key.pem";
//            File file = new File(filepath);
//            try ( FileOutputStream fos = new FileOutputStream(file) ) {
//                fos.write(data, 0, data.length);
//            }
//        } catch ( Exception e ) {
//            LOGGER.info( e.getMessage() );
//        }
        /*
        测试Redis
         */
        CacheService cacheService = new RedisCacheService();
        cacheService.set( "test", "123", Duration.ofMinutes(3));
        /*
        测试索引服务
         */
        int userId = 123456;
        String userName = "andy yuan";
        String mobile = "13333333333";
        //
        UserDocument user = new UserDocument( userId, userName, mobile );
        userIndexService.save( user );
        //
        user = userIndexService.getUser( userId );
        LOGGER.info( "Test Index: >>> {} {} {}", user.getId(), user.getName(), user.getMobile() );
        /*
        测试消息服务
         */
        boolean sendMessageResult = messageService.send( "TestTopic", 123 );
        LOGGER.info( "Test send msg: >>> {}", sendMessageResult );
        //
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
