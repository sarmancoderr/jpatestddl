package es.sarman.jpatestddl.CLI;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FirstCommand {

    public static void main(String[] args) {
        ConfigurableApplicationContext context1 = new SpringApplicationBuilder(FirstCommand.class)
                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("CODIGO PERSONALIZADO");

        context1.stop();
    }

}
