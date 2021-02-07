package lark.example.msg.contract.message;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class OrderMessage {
    private long orderId;
    int userId;
    LocalDateTime createTime;
}
