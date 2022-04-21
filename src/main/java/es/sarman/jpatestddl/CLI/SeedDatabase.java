package es.sarman.jpatestddl.CLI;

import es.sarman.jpatestddl.JpatestddlApplication;
import es.sarman.jpatestddl.SeedFactories.UserSeedFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SeedDatabase {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpatestddlApplication.class);
        UserSeedFactory bean = context.getBean(UserSeedFactory.class);
        bean.generateNInstances(200);
        context.stop();
    }

}
