package com.project.cardgame.controller;

import com.project.cardgame.dto.SampleObject;
import com.project.cardgame.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(produces = "application/hal+json")
public class SampleController {

    /* entry point first start here:
        check -> https://www.baeldung.com/spring-boot
        official initial notes: https://spring.io/guides/gs/spring-boot/
        spring documentation: https://devdocs.io/spring_boot/ (The best to refer)
        1. https://levelup.gitconnected.com/how-to-follow-good-coding-standards-in-spring-boot-a22dd735e3ec
        2. https://www.baeldung.com/rest-with-spring-series
        3. https://www.youtube.com/watch?v=GdAon80-0KA -> java collections framework
        4. https://www.youtube.com/watch?v=vtPkZShrvXQ -> spring boot tutorial
        5.

     */
    @Autowired
    SampleService sampleService;

    @GetMapping(value = "/actuator/health")
    public String sampleEndPoint() {
        // read why actuator is used?
        // you can refer => https://www.geeksforgeeks.org/spring-boot-actuator/ && https://www.baeldung.com/spring-boot-actuators
        // FYI: it is a best practice, this can be utilized to fetch the status of microservice
        // (in simple words to check if our microservice is up or down)
        return  "Up";
    }

    @GetMapping(value = "/ping")
    public String sampleEndPoint(
            @RequestParam(value = "name", defaultValue = "pong") String name
    ) {
        return "Hi " + name;
    }
    @GetMapping(value = "/exception")
    public String sampleEndPointToThrowException(
            @RequestParam("name") String name
    ) {
        log.info("Received request to fetch name");
//        log.debug("");
//        log.error("");
        String result = sampleService.fetchName(name);
        log.info("Fetched name: " + result);
        return result;
    }

    @PostMapping(value = "/fetch-object")
    public ResponseEntity<SampleObject> sampleEndPointToFetchObject_Plain() {
        // read about responseEntity here => https://www.baeldung.com/spring-response-entity
        /*
            The difference is quite easy to explain. When you use ResponseEntity, you have full control about the contents of your response.
            You can change your headers, status code, ... When you don't use ResponseEntity as the return type of a controller method, spring will "automagically" create a default ResponseEntity.
            So the biggest advantage in using ResponseEntity is that you have full control. The disadvantage is that it is more verbose than letting Spring work its magic.
        */
        log.info("Received request to fetch object");
//        log.debug("");
//        log.error("");
        SampleObject result = sampleService.fetchObject("sample");
        log.info("Fetched name: " + result);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/fetch-object/plain")
    public SampleObject sampleEndPointToFetchObject() {
        log.info("Received request to fetch object");
//        log.debug("");
//        log.error("");
        SampleObject result = sampleService.fetchObject("sample");
        log.info("Fetched name: " + result);
        return result;
    }
}
