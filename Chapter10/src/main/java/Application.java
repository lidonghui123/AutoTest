import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//把固定格式进行托管
@SpringBootApplication
@EnableScheduling
@ComponentScan("com.course")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);//固定格式写法
    }
}


/*@EnableScheduling
@SpringBootApplication
public class Application {
    //为了资源方面处理的更好
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.context = SpringApplication.run(Application.class, args);
    }

    @PreDestroy
    public void close() {
        Application.context.close();
    }
}
*/