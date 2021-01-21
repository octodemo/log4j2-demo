package log4j2.demo;

import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        run("Request-0001");
        run("Request-0002");
        run("Request-0003");
    }

    private static void run(String id) {
        ThreadContext.put("RequestId", id);

        logger.info("This is an Info Message!");
        logger.warn("This is a warn Message!");
        try {
            System.out.println(100/0);
        }
        catch(Exception e) {
            logger.error("Error Occurred", e);
        } finally {
            ThreadContext.remove("RequestId");
        }
    }
}
