package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-02 13:33
 */
@SpringBootApplication
public class SpringBootApplications {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplications.class, args);
    }
}
