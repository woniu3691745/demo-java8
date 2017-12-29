package spring.annotation;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-12-29 15:01
 */
public class MyServiceImpl implements MyService {

    @Override
    public void doStuff() {
        System.out.println("hello my service");
    }
}
