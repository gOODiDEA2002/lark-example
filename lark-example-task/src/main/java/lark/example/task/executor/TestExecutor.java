package lark.example.task.executor;

import lark.example.task.biz.TestBiz;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * XxlJob开发示例（Bean模式）
 *
 * 开发步骤：
 * 1、在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
 * 2、为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author xuxueli 2019-12-11 21:52:51
 */
@Component
public class TestExecutor {
    @Autowired
    TestBiz testBiz;

    @XxlJob("TestHandler")
    public ReturnT<String> testHandler(String param) throws Exception {
        int[] userIds = new int[]{123,1,0,124};
        for (int i = 0, count = userIds.length; i < count; i++) {
            String result = testBiz.hello( userIds[i] );
            XxlJobLogger.log("result:{}", result );
        }
        return ReturnT.SUCCESS;
    }
}
