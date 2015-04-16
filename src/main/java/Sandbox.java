import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */

/**
 * @author herb
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Sandbox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Sandbox.class, args);

	}

}
