package lark.example.task;

import lark.task.boot.TaskApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author andy
 */
@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) {
        TaskApplication app = new TaskApplication(Bootstrap.class);
        app.run( args );
    }
}
