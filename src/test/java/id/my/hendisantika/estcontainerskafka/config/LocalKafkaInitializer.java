package id.my.hendisantika.estcontainerskafka.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.shaded.org.checkerframework.checker.nullness.qual.NonNull;
import org.testcontainers.utility.DockerImageName;

import static java.lang.System.setProperties;

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

    private void kafkaLocalSetup(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        KafkaContainer kafka = new KafkaContainer(
                DockerImageName.parse("confluentinc/cp-kafka:7.2.2.arm64"))
                .withEnv("KAFKA_AUTO_CREATE_TOPICS_ENABLE", "true")
                .withEnv("KAFKA_CREATE_TOPICS", "kafka_topic");
        kafka.start();
        setProperties(environment, "kafka.config.bootstrap-server", kafka.getBootstrapServers());
    }
}
