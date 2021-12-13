package lark.example.api.controller;

import lark.api.response.ApiFaultException;
import lark.api.web.ApiRestController;
import lark.core.util.Strings;
import lark.db.DatabaseService;
import lark.db.jsd.Database;
import lark.example.api.biz.TestBiz;
import lark.example.api.contract.iface.TestApi;
import lark.example.api.contract.vo.TestVo;
import lark.example.api.index.UserDocument;
import lark.example.api.index.UserIndexService;
import lark.example.msg.contract.message.OrderMessage;
import lark.example.msg.contract.publisher.OrderPublisher;
import lark.msg.Publisher;
import lark.util.cache.CacheService;
import lark.util.cache.LockService;
import lark.util.cache.RateLimitService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import static lark.db.jsd.Shortcut.f;

@ApiRestController
public class TestController implements TestApi {

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class UserItem {
        int id;
        String name;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestBiz testBiz;


    @Autowired
    UserIndexService userIndexService;

    @Autowired
    CacheService cacheService;

    @Autowired
    LockService lockService;

    @Autowired
    RateLimitService rateLimitService;

    @Autowired
    Publisher publisher;

    @Autowired
    DatabaseService databaseService;

    @Override
    public TestVo.HelloResponse hello(TestVo.HelloRequest hello) throws IOException {
        Database db = databaseService.get( "user_master" );
        User dbuser = db.select("id", "name" )
                .from( "users" )
                .where( f( "id", 123 ) ).result().one( User.class );
        LOGGER.info( "DB User: >>> id: {}", dbuser.getId() );
        //
        long shardOrderId = 2;
        db = databaseService.getShard( "order" );
        Order order = db.select( "order_id", "user_id", "sku_id" ).from( "order").where( f( "order_id", shardOrderId )).result().one( Order.class );
        LOGGER.info( "DB Order: >>> id: {}", order.getUserId() );
        /*
        测试消息服务
         */
        //publisher.publish( "TestTopic", "123456", Duration.ofMinutes( 10 ) );
        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setOrderId( 123 );
        orderMessage.setUserId( 456 );
        orderMessage.setCreateTime(LocalDateTime.now());
        //
        OrderPublisher orderPublisher = new OrderPublisher( publisher );
        orderPublisher.orderCreate( orderMessage );
        /*
        测试缓存服务
         */
        cacheService.set( "test", "123", Duration.ZERO);
        String v = cacheService.get( "test" );
        LOGGER.info( "Test Cache: >>> test: {}", v );
        UserItem item = new UserItem();
        item.setId(123);
        item.setName( "123");
        cacheService.set( "testuser", item, Duration.ofMinutes( 3 ) );
        item = cacheService.get( "testuser", UserItem.class );
        LOGGER.info( "Test Cache: >>> userid: {}", item.getId() );
        //
        int orderId = 1000;
        String lockKey = String.format( "test-api-order-%d", orderId );
        //等待锁，180秒
        int waitSec = 180;
        //获取锁60秒以后自动解锁
        int autoUnlock = 60;
        int result = lockService.tryLock( lockKey, waitSec, autoUnlock, () -> {
            LOGGER.info( "Thread:{} lockService get lock", Thread.currentThread().getName() );
            //耗时操作，如：
            try {
                Thread.sleep(1000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info( "Thread:{} lockService unlock", Thread.currentThread().getName() );
            //返回值可以为多种类型，这里是整型
            return 0;
        });
        LOGGER.info( "Test Cache: >>> userid: {}", item.getId() );
        //
        String rateLimitKey = String.format( "test-api-order-%d", orderId );
        int rate = 1;
        int intervalSecond = 60;
        boolean exec = rateLimitService.tryProcess( rateLimitKey, rate, intervalSecond, () -> {
            LOGGER.info( "Thread:{} rateLimitService exec {}/{}s", Thread.currentThread().getName(), rate, intervalSecond );
        });
        if ( !exec ) {
            LOGGER.info( "Thread:{} rateLimitService Limited {}/{}s", Thread.currentThread().getName(), rate, intervalSecond );
        }
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
//        /*
//        测试消息服务
//         */
//        boolean sendMessageResult = messageService.send( "TestTopic", 123 );
//        LOGGER.info( "Test send msg: >>> {}", sendMessageResult );
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
