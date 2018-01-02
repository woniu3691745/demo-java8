package spring.asyncresttemplate;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * ${DESCRIPTION}
 *
 * @author lidongliang
 * @create 2018-01-01 下午3:17
 **/
@RestController
public class UserConstoller {

    @RequestMapping("/api")
    public Callable<User> api() {
        System.out.println("========hello");
        return () -> {
            Thread.sleep(1000);
            User user = new User();
            user.setId(1L);
            user.setDate(new Date());
            user.setName("lidongliang");
            return user;
        };
    }

    @RequestMapping("/user")
    public void throwException() {
        if (2 > 1) {
            throw new RuntimeException();
        } else {
            System.out.println("success");
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public void handlerException() {
        System.out.println("failure");
    }
}
