package com.test.common;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.test.rabbit.MessageConsumer.SampleOne;
import com.test.rabbit.MessageConsumer.SampleTwo;

@Component
public class SampleConsumer {

    @StreamListener(SampleOne.SAMPLE_ONE)
    public void sampleOneListener(@Payload String msg) {
        System.out.println("::: SAMPLE_ONE consumed [direct] :::");
        System.out.println(msg);
    }

    @StreamListener(SampleTwo.SAMPLE_TWO)
    public void sampleTwoListener(@Payload String msg) {
        System.out.println("::: SAMPLE_TWO consumed [subscribe] :::");
        System.out.println(msg);
    }
}
