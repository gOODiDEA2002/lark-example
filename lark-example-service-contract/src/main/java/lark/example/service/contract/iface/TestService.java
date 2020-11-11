package lark.example.service.contract.iface;

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
	@PostMapping(value = "/hello.srv")
	HelloResponse hello(HelloRequest request);
}