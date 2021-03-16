package lark.example.api.controller;

import lark.db.jsd.NameStyle;
import lark.db.jsd.annotation.JsdTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsdTable(nameStyle = NameStyle.LOWER)
public class Order {
    private long orderId;
    private long userId;
    private int skuId;
}