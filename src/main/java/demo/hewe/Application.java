package demo.hewe;

import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
