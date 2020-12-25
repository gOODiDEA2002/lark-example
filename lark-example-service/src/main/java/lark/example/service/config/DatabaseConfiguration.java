package lark.example.service.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lark.db.sql.SqlQuery;
import org.apache.shardingsphere.core.yaml.swapper.ShardingRuleConfigurationYamlSwapper;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.apache.shardingsphere.shardingjdbc.spring.boot.sharding.ShardingRuleCondition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author andy
 */
@Configuration
public class DatabaseConfiguration {

    @Bean(name = "orderSqlQuery")
    public SqlQuery orderSqlQuery(DataSource shardingDataSource) {
        return new SqlQuery(shardingDataSource);
    }

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.user")
    public DataSource userDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "userSqlQuery")
    public SqlQuery userSqlQuery(@Qualifier("userDataSource") DataSource userDataSource) {
        return new SqlQuery(userDataSource);
    }
}
