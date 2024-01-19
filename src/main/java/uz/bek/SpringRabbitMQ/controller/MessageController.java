package uz.bek.SpringRabbitMQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.bek.SpringRabbitMQ.model.Product;
import uz.bek.SpringRabbitMQ.model.User;
import uz.bek.SpringRabbitMQ.service.RabbitMQProducer;

@RestController
public class MessageController {
    @Autowired
    private RabbitMQProducer rabbitMQService;
    @PostMapping("product")
    public ResponseEntity<String> sendMessage(@RequestBody Product message){
        rabbitMQService.sendMessage(message);
        return ResponseEntity.ok("Product sent");
    }
    @PostMapping("user")
    public ResponseEntity<String> sendMessage(@RequestBody User message) {
        rabbitMQService.sendMessage(message);
        return ResponseEntity.ok("User sent");
    }
}
