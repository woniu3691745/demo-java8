package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-12-26 16:04
 */

public class SpringApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        BeanTest beanTest = (BeanTest) applicationContext.getBean("syaHello");
        BeanTest beanTest1 = applicationContext.getBean("syaHello", BeanTest.class);
        beanTest1.SyaHello();

    }
}
