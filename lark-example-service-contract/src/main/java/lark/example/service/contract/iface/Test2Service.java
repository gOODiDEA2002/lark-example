package lark.example.service.contract.iface;

import lark.example.service.contract.dto.GetOrderDto;
import lark.example.service.contract.dto.TestDto.HelloRequest;
import lark.example.service.contract.dto.TestDto.HelloResponse;
import lark.net.rpc.annotation.RpcMethod;
import lark.net.rpc.annotation.RpcService;

/**
 * 测试服务
**/
//@RestController
//@RequestMapping("/test")
@RpcService
public interface Test2Service {
	/**
	 * 测试
	**/
	//@PostMapping( "/hello.srv")
	@RpcMethod
	HelloResponse hello2( HelloRequest request);
}