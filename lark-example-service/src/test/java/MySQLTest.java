import static lark.db.sql.SqlHelper.f;
import static lark.db.sql.SqlHelper.t;

import lark.db.sql.InsertResult;
import lark.db.sql.SqlQuery;
import lark.example.service.Bootstrap;
import lark.example.service.dao.TestDao;
import lark.example.service.entity.TestDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@RunWith(SpringRunner.class )
@SpringBootTest(classes = {Bootstrap.class})
@ActiveProfiles("qa")
public class MySQLTest {
    @Autowired
    TestDao dao;

    @Autowired
    @Qualifier("orderSqlQuery")
    SqlQuery orderSqlQuery;

    @Autowired
    DataSource shardingDataSource;
    public static final String INSERT = "INSERT INTO t_order (order_id, user_id, sku_id) VALUES ( ?, ?, ?)";

    @Test
    public void test() throws IOException, SQLException {
//        File configFile = ResourceUtils.getFile("classpath:database.order.config.yml");
//        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource( configFile );
//        try (Connection connection = dataSource.getConnection();
//        try (Connection connection = shardingDataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
//            preparedStatement.setLong(1, 1);
//            preparedStatement.setLong(2, 1);
//            preparedStatement.setInt(3, 1);
//            int ir = preparedStatement.executeUpdate();
//            System.console().printf( "result:%s", ir );
//        } catch (SQLException sqlException ) {
//            sqlException.printStackTrace();
//        }
        //
        //
        Map<String, Object> selectResult = orderSqlQuery.select( "order_id", "user_id" ).from( "t_order").where( f( "order_id", 2 )).one();
        if ( selectResult != null ) {
            System.out.printf("{ select %s}", selectResult.toString());
        }
        int dr = orderSqlQuery.delete( "t_order", f( "order_id", 2 ) );
        System.out.printf("{ delete affectedRows: %d}%n", dr );
        //
        InsertResult result = orderSqlQuery.insert( "t_order" ).columns( "order_id", "user_id", "sku_id" ).values(2,2,2).result();
        System.out.printf("{ insert affectedRows: %d}%n", result.getAffectedRows());
        //

        //
        //Order order = new Order();

        //User user = dao.getUser( 123 );

        //
        TestDO user = dao.getObject( 123 );
        Assert.isTrue( user.getId() == 123, user.getName() );
    }
}
