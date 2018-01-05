package spring.aop.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-03 11:07
 */
@Service
public class NeedLogService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Random random = new Random(System.currentTimeMillis());

    public String logMethod(String someParam) {
        logger.info("---NeedLogService: logMethod invoked, param: {}---", someParam);
        return String.valueOf(System.currentTimeMillis());
    }

    public void exceptionMethod() throws Exception {
        logger.info("---NeedLogService: exceptionMethod invoked---");
        throw new Exception("Something bad happened!");
    }
}
