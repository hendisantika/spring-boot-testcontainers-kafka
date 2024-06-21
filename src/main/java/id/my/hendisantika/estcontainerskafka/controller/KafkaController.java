package id.my.hendisantika.estcontainerskafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-testcontainers-kafka
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/24
 * Time: 07.46
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequestMapping("/kafka/topic")
@RequiredArgsConstructor
public class KafkaController {
    private static final String TOPIC = "kafka_topic";
    private final KafkaTemplate<String, String> kafkaTemplate;
}
