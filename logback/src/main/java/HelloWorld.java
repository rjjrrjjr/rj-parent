import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 10064028 on 2018/1/18.
 */
public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        logger.info("info__logback");

        logger.trace("trace__logback");
        logger.debug("debug__logback");
        logger.error("error__logback");

        logger.error("岗位[{}]绩效分{}计算失败", 213, "gsgsgsd");
        System.out.println(String.format("sdgsdhbdfh%safdsgfgf%d", "===================", 2342));
    }
}
