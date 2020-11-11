package lark.example.msg.contract.dto;

import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class TestMessage {
    private long orderId;
    int userId;
}
