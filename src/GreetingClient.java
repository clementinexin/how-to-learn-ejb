import org.sky.Greeting;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

/**
 * ClassName: GreetingClient <br/>
 * Description: TODO <br/>
 * Date: 2016-03-29 17:29 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-03-29 jdai@ created. <br/>
 */
public class GreetingClient {

    public static void main(String[] args) throws IOException, NamingException {
        Properties props = new Properties();
        props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jndi.properties"));
        InitialContext context = new InitialContext(props);
        Greeting greeting = (Greeting) context.lookup("GreetingImpl/remote");
        System.out.println(greeting.greet("Enterprise Java Bean"));
    }
}
