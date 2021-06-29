package ytkach.spring.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import ytkach.spring.core.beans.Client;

import java.text.DateFormat;
import java.util.Date;

@Configuration
@PropertySource("classpath:client.properties")
@Import(LoggerConfig.class)
public class AppConfig {

    final Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Date newDate(){
        return new Date();
    }

    @Bean
    public DateFormat dateFormat(){
        return DateFormat.getDateTimeInstance();
    }

    @Bean
    public Client client(){
        Client client = new Client();
        client.setId(environment.getRequiredProperty("id"));
        client.setName(environment.getRequiredProperty("name"));
        client.setGreeting(environment.getProperty("greeting"));
        return client;
    }
}
