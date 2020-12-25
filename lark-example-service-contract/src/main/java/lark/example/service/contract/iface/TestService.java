package lark.example.service.contract.iface;

import lark.example.service.contract.dto.GetOrderDto;
import lark.example.service.contract.dto.TestDto.*;
import org.springframework.web.bind.annotation.*;

/**
 * 测试服务
**/
@RestController
@RequestMapping("/test")
public interface TestService {
	/**
	 * 测试
	**/
	@PostMapping( "/hello.srv")
	HelloResponse hello(@RequestBody HelloRequest request);

	@PostMapping( "/order/get.srv")
	GetOrderDto.GetOrderResponse getOrder(@RequestBody GetOrderDto.GetOrderRequest request);
}