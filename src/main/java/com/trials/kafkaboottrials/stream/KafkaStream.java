package com.trials.kafkaboottrials.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaStream {

    @Bean
    public KStream<String, String> kStream (StreamsBuilder kStreamBuilder) {
        KStream<String, String> inputTopicStream = kStreamBuilder
                .stream("device-incidents-topic-1", Consumed.with(Serdes.String(),Serdes.String()));

        inputTopicStream.foreach((k,v)->{System.out.println("key:"+k+"value:"+v);});

        inputTopicStream.print(Printed.<String,String>toSysOut().withLabel("original stream"));

        inputTopicStream.to("risk-incidents-topic-1", Produced.with(Serdes.String(),Serdes.String()));

        return inputTopicStream;
    }
}
