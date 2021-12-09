package lark.example.api.contract.iface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lark.example.api.contract.vo.TestVo.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/test")
@Tag(name = "测试接口")
public interface TestApi {

    @Operation(summary="Hello")
    @ApiResponse(responseCode="200", description="Hello", content = @Content( schema = @Schema( implementation = HelloResponse.class )) )
    @PostMapping("/hello.api")
    public HelloResponse hello(@Parameter(schema=@Schema( implementation = HelloRequest.class ) )
                                           HelloRequest hello ) throws IOException;
}