package lark.example.api.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private long orderId;
    private long userId;
    private int skuId;
}