package lark.example.msg.contract.config;

import lark.example.msg.contract.publisher.TestPublisher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 提供 Spring 自动注入默认服务代理功能。
 * @author andy
 */
@Configuration
public class AutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TestPublisher getOrderPublisher() {
        return new TestPublisher();
    }
}
