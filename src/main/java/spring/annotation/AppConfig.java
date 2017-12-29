package spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-12-29 14:56
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class AppConfig {

    @Bean
    @Description("this is bean.")
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Autowired
    Environment env;

    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName(env.getProperty("testbean.name"));
        return testBean;
    }
}
