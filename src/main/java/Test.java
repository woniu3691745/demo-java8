import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.bean.BeanFirst;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

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


    @RequestMapping("/something")
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();
        return new ResponseEntity(HttpStatus.OK);
    }

}
