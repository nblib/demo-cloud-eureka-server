package demo.hewe;

import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EurekaServerAutoConfiguration;

/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class Application
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
