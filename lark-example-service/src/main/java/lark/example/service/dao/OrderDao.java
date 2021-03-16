package lark.example.service.dao;

import lark.db.DatabaseService;
import lark.db.jsd.Database;
import lark.example.service.entity.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static lark.db.jsd.Shortcut.f;

@Repository
public class OrderDao {

    @Autowired
    DatabaseService databaseService;

    public OrderDO getOrder(long orderId) {
        Database orderSqlQuery = databaseService.getShard( "order" );
        List<OrderDO> orders = orderSqlQuery.select( "order_id", "user_id", "sku_id" ).
                from( "order").
                where( f( "order_id", orderId )).
                result().
                all( OrderDO.class );
        if ( orders != null && orders.size() > 0 ) {
            return orders.get(0);
        }
        return null;
    }
}