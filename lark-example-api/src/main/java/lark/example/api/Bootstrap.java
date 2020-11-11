package lark.example.api;

import lark.api.boot.ApiApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) {
        ApiApplication app = new ApiApplication(Bootstrap.class);
        app.run( args );
    }
}
