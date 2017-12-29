package spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-12-29 14:59
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        MyService myService = ctx.getBean(MyService.class);
        myService.doStuff();

        System.out.println(ctx.getBean(TestBean.class).getName());
    }
}
