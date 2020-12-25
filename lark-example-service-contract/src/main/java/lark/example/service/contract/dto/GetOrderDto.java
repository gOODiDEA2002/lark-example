package lark.example.service.contract.dto;

import lark.example.service.contract.constant.TestType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class GetOrderDto {
    /**
     * 请求参数
     */
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class GetOrderRequest {
        /**
         * ID
         */
        private long orderId;
    }

    /**
     * 响应结果
     */
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class GetOrderResponse {
        /**
         * 订单ID
         */
        private long orderId;
        /**
         * 用户ID
         */
        private long userId;

        /**
         * SKUID
         */
        private int skuId;
    }
}