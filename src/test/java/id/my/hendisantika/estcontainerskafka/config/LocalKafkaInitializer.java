package id.my.hendisantika.estcontainerskafka.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.shaded.org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-testcontainers-kafka
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/24
 * Time: 07.52
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class LocalKafkaInitializer implements
        ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(@NonNull ConfigurableApplicationContext context) {
        kafkaLocalSetup(context);
    }
}
