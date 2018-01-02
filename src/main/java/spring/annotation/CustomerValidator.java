package spring.annotation;

import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-02 13:34
 */
@RestController
@RequestMapping("/validator")
public class CustomerValidator {

    @RequestMapping("/test")
    public String validatorTest(@Validated Address address, BindException br) {
        if(br.hasErrors()) {
            return "";
        }else {
            return "noErrors";
        }
    }

    @RequestMapping("/test1")
    @NoLogin(value = "true")
    public String validatorTest1() {
        return "noErrors";
    }
}
