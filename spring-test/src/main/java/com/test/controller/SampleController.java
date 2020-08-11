package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.rabbit.MessageProducer.SampleOne;
import com.test.rabbit.MessageProducer.SampleTwo;

@RestController
public class SampleController {
    @Autowired
    SampleOne sampleOne;

    @Autowired
    SampleTwo sampleTwo;

    @GetMapping("/sample1")
    public void produceSample1(@RequestParam("msg") String msg) {
        System.out.println("::: SAMPLE_ONE publish [direct] :::");
        sampleOne.publish().send(MessageBuilder.withPayload("{msg : " + msg + "}").build());
    }

    @GetMapping("/sample2")
    public void produceSample2(@RequestParam("msg") String msg) {
        System.out.println("::: SAMPLE_TWO publish [subscribe] :::");
        sampleTwo.publish().send(MessageBuilder.withPayload("{msg : " + msg + "}").build());
    }
}
