package spring.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.aop.app.config.NeedLogService;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-03 9:18
 */
@RestController
@RequestMapping("/web")
public class WebController {

    @Autowired
    private NeedLogService needLogService;

    @RequestMapping("/method")
    public String method1() {
//        needLogService.logMethod("xys");
//        needLogService.exceptionMethod();
        return "method1";
    }

    @RequestMapping("/method/{id}")
    public String method2(@PathVariable String id) {
//        needLogService.logMethod("xys");
//        needLogService.exceptionMethod();
        return "method2";
    }
}
