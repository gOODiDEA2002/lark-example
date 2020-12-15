package lark.example.api;

import lark.api.boot.ApiApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class} )
public class Bootstrap {
    public static void main(String[] args) {
        ApiApplication app = new ApiApplication(Bootstrap.class);
        app.run( args );
    }
}
