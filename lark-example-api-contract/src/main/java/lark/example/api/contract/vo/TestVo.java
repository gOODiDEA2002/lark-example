package lark.example.api.contract.vo;

import io.swagger.v3.oas.annotations.media.Schema;
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
        @Schema(description = "ID of the HelloRequest.",
                example = "123", required = true )
        private int id;
        /**
         * 姓名
         */
        @Schema(description = "Name of the HelloRequest.",
                example = "noname", required = false)
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
        @Schema(description = "result of the Hello.",
                example = "JSON 字符串", required = true )
        private String result;
        /**
         * 时间
         */
        @Schema(description = "服务器当前时间戳",
                example = "1639119969210", required = true )
        private long time;
    }
}
