package lark.example.api.contract.vo;

import lombok.*;
/**
 * Created by Andy Yuan on 2020/11/9.
 */
public class TestVo {
    /**
     * 请求参数
     */
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class HelloRequest {
        /**
         * ID
         */
        private int id;
        /**
         * 姓名
         */
        private String name;
    }

    /**
     * 响应结果
     */
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class HelloResponse {
        /**
         * 结果
         */
        private String result;
        /**
         * 时间
         */
        private long time;
    }
}
