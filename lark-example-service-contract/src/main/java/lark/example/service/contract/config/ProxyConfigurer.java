package lark.example.service.contract.config;

import lark.net.rpc.ServiceProxy;
import lark.example.service.contract.iface.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfigurer {
    private final String SERVER = "lark-example-service";

    private ServiceProxy serviceProxy;

    @Autowired
    public ProxyConfigurer(ServiceProxy serviceProxy) {
        this.serviceProxy = serviceProxy;
    }

    @Bean
    @ConditionalOnMissingBean
    public TestService testService() {
        return serviceProxy.get(SERVER, TestService.class);
    }
}