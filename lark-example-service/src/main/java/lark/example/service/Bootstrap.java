package lark.example.service;

import lark.service.boot.ServiceApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) {
        ServiceApplication app = new ServiceApplication(Bootstrap.class);
        app.run(args);
    }
}