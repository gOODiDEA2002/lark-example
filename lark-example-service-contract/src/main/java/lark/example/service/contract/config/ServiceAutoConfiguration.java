package lark.example.service.contract.config;

import lark.example.service.contract.*;
import lark.example.service.contract.iface.*;
import lark.net.rpc.client.ServiceFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author andy
 */
@Configuration
public class ServiceAutoConfiguration {
    private static final String PACKAGE_NAME = "lark.example.service.contract.iface";
    private static final String SERVER_NAME = "lark-example-service";
    private final ServiceFactory serviceFactory;

    public ServiceAutoConfiguration(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Bean
    @ConditionalOnMissingBean
    public TestService testService() {
        return serviceFactory.get(SERVER_NAME, TestService.class);
    }

    @Bean
    @ConditionalOnMissingBean
    public ExampleServiceManager serviceManager() {
        ExampleServiceManager serviceManager = new ExampleServiceManager( serviceFactory );
        serviceManager.registry( PACKAGE_NAME, SERVER_NAME );
        return serviceManager;
    }
}