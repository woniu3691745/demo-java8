import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.BeanFirst;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-03 8:51
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        java.util.Properties properties = (java.util.Properties)ctx.getBean("jdbcConfiguration");
//        System.out.println(properties.get("name"));
        BeanFirst beanFirst = (BeanFirst)ctx.getBean("beanFirst");
        beanFirst.getFirstBean();
        Test test = new Test();
    }

}
