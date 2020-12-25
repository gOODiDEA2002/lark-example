package lark.example.service.dao;

import lark.db.sql.SqlQuery;
import lark.example.service.entity.Order;
import lark.example.service.entity.TestObject;
import lark.example.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import static lark.db.sql.SqlHelper.f;

@Repository
public class OrderDao {

    @Autowired
    @Qualifier("orderSqlQuery")
    SqlQuery orderSqlQuery;

    public Order getOrder(long orderId) {
        Order order = orderSqlQuery.select( "order_id", "user_id", "sku_id" ).from( "t_order").where( f( "order_id", orderId )).one( Order.class );
        return order;
    }
}