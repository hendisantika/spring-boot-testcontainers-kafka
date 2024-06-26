package id.my.hendisantika.testcontainerskafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-testcontainers-kafka
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/24
 * Time: 07.44
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class KafkaConfig {
    @Bean
    public ProducerFactory<String, String> producerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaProducerFactory<>(kafkaProperties.kafkaConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(KafkaProperties kafkaProperties,
                                                       ProducerFactory<String, String> producerFactory) {
        System.setProperty("java.security.krb5.conf", kafkaProperties.getKrb5Conf());
        System.setProperty("java,security,auth.login.config", kafkaProperties.getLoginConf());
        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
        System.setProperty("sun.security.krb5.debug", kafkaProperties.getKrb5Debug());
        return new KafkaTemplate<>(producerFactory);
    }
}
