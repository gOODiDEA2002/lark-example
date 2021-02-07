package lark.example.service.biz;

import lark.example.service.dao.OrderDao;
import lark.example.service.entity.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBiz {
    @Autowired
    private OrderDao orderDao;

    public OrderDO getOrder(long orderId ) {
        return orderDao.getOrder( orderId );
    }
}
