package com.swellwu.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-31
 */
@Configuration
@ImportResource("classpath:spring/applicationContext-*.xml")
public class RabbitMqConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
