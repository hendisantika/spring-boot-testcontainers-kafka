package id.my.hendisantika.testcontainerskafka;

import id.my.hendisantika.testcontainerskafka.config.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KafkaProperties.class)
public class SpringBootTestcontainersKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestcontainersKafkaApplication.class, args);
    }

}
