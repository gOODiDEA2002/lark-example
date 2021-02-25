package lark.example.service.contract.iface;

import lark.example.service.contract.dto.GetOrderDto;
import lark.example.service.contract.dto.TestDto.HelloRequest;
import lark.example.service.contract.dto.TestDto.HelloResponse;
import lark.net.rpc.annotation.RpcMethod;
import lark.net.rpc.annotation.RpcService;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试服务
**/
//@RestController
//@RequestMapping("/test")
@RpcService
public interface TestService {
	/**
	 * 测试
	**/
	//@PostMapping( "/hello.srv")
	@RpcMethod
	HelloResponse hello( HelloRequest request);

	@RpcMethod
	GetOrderDto.GetOrderResponse getOrder( GetOrderDto.GetOrderRequest request);
}