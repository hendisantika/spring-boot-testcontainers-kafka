package id.my.hendisantika.testcontainerskafka;

import id.my.hendisantika.testcontainerskafka.config.LocalKafkaInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = "id.my.hendisantika.testcontainerskafka")
@ConfigurationPropertiesScan(basePackages = "id.my.hendisantika.testcontainerskafka")
class SpringBootTestcontainersKafkaApplicationTests {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootTestcontainersKafkaApplicationTests.class).initializers(new LocalKafkaInitializer())
                .run(args);
    }

}
