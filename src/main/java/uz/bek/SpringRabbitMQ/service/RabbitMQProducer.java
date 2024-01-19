package uz.bek.SpringRabbitMQ.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.bek.SpringRabbitMQ.model.Product;
import uz.bek.SpringRabbitMQ.model.User;

@Service
public class RabbitMQProducer {
    @Value("${rabbitmq.routing.product.key}")
    private String productRoutingKey;
    @Value("${rabbitmq.routing.user.key}")
    private String userRoutingKey;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    private static Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
    @Autowired
    private RabbitTemplate template;
    public void sendMessage(Product message){
        template.convertAndSend(exchange,productRoutingKey, message);
        LOGGER.info("message sent to the exchange: "+message);
    }
    public void sendMessage(User message){
        template.convertAndSend(exchange,userRoutingKey, message);
        LOGGER.info("message sent to the exchange: "+message);
    }
}
