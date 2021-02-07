package lark.example.service.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderDO {
    private long orderId;
    private long userId;
    private int skuId;
}