package com.test.rabbit;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@EnableBinding({ MessageProducer.SampleOne.class, MessageProducer.SampleTwo.class })
public class MessageProducer {

    public interface SampleOne {
        String SAMPLE_ONE = "sample-one";

        @Output(SAMPLE_ONE)
        MessageChannel publish();
    }

    public interface SampleTwo {
        String SAMPLE_TWO = "sample-two";

        @Output(SAMPLE_TWO)
        MessageChannel publish();
    }
}