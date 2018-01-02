package spring.readproperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-02 16:36
 */
@Configuration
@PropertySource("classpath:/application.properties")
public class PropertyInfo {

    @Autowired
    Environment env;

    public void testBean() {
        System.out.println(env.getProperty("name"));
    }
}
