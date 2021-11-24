package com.trials.kafkaboottrials.simple;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleConsumer {
	
	@KafkaListener(topics = "risk-incidents-topic-1", groupId = "group_id_1")
    public void consume(String message) {
		System.out.println("inside simple consumer");
        System.out.println("Consumed message: " + message);
    }

}
