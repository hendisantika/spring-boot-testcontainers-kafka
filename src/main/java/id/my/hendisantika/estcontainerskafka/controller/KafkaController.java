package id.my.hendisantika.estcontainerskafka.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

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
@Tag(name = "Kafka", description = "Endpoint for managing Kafka Message")
public class KafkaController {
    private static final String TOPIC = "kafka_topic";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(path = "/{message}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Get All Tutorials Data",
            description = "Get All Tutorials Data.",
            tags = {"Tutorial"})
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            String.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public ResponseEntity<String> sendMessage(@PathVariable("message") String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, "key",
                message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[" + message + "] with offset=["
                        + result.getRecordMetadata().offset() + "]");
            } else {
                log.warn("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
        return new ResponseEntity<>(
                "Finish sending [" + message + "], Check log to know the result", HttpStatus.OK);
    }
}
