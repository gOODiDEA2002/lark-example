package lark.example.task.executor;

import lark.example.task.biz.TestBiz;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lark.task.Executor;
import lark.task.Task;
import lark.task.TaskContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Task
public class TestTask implements Executor {
    @Autowired
    TestBiz testBiz;

    @Override
    public void execute(TaskContext ctx) {
        int[] userIds = new int[]{123,1,0,124};
        for ( int userId : userIds ) {
            String userName = testBiz.hello( userId );
            ctx.info( "===> UserId: {}, UserName: {}", userId, userName );
        }
    }
}
