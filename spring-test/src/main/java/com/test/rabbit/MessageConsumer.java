package com.test.rabbit;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding({ MessageConsumer.SampleOne.class, MessageConsumer.SampleTwo.class, })
public class MessageConsumer {

    public interface SampleOne {
        String SAMPLE_ONE = "sample-one";

        @Input(SAMPLE_ONE)
        SubscribableChannel consume();
    }

    public interface SampleTwo {
        String SAMPLE_TWO = "sample-two";

        @Input(SAMPLE_TWO)
        SubscribableChannel consume();
    }
}
