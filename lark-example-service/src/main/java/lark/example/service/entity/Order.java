package lark.example.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
public class Order {
    private long orderId;
    private long userId;
    private int skuId;
}