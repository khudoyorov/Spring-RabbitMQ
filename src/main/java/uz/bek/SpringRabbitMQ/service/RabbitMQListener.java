package uz.bek.SpringRabbitMQ.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import uz.bek.SpringRabbitMQ.model.Product;
import uz.bek.SpringRabbitMQ.model.User;

@Service
public class RabbitMQListener {

    private static Logger LOGGER = LoggerFactory.getLogger(RabbitMQListener.class);

    @RabbitListener(queues = {"${rabbitmq.queue.product.name}"})
    public void consume(Product message){
        LOGGER.info("Consumed message from product queue: "+message.toString());
    }

    @RabbitListener(queues = {"${rabbitmq.queue.user.name}"})
    public void consume(User message){
        LOGGER.info("Consumed message from user queue: "+message.toString());
    }
}
