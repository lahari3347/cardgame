package com.project.cardgame.service;

import com.project.cardgame.dto.SampleObject;
import com.project.cardgame.dto.SampleObjectUsingBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SampleServiceImpl implements SampleService{

    @Override
    public String fetchName(String name) {
        try{
//            throw new RuntimeException("runtime exception");
            return name + " sampleName";
        }
        catch (Exception exception){
            log.error("Exception while fetching name: " +  exception.getMessage());
            throw new RuntimeException("Exception while fetching name: " +  exception.getMessage());
        }
    }

    @Override
    public SampleObject fetchObject(String name) {
        SampleObject sampleObject = new SampleObject();
        sampleObject.setVar1(1);
        sampleObject.setVar2(1);
        sampleObject.setVar3("3");

        // another way of creating objects using BuilderPattern
        // spring supports this designPattern with @Builder annotation
        // this will reduce coding effort to ignore setters
        // read about design pattern here =>
        // https://medium.com/@raviyasas/practical-use-of-the-builder-design-pattern-in-spring-boot-7fbeef231b16
        // https://medium.com/thedevproject/mastering-the-builder-pattern-in-spring-boot-from-basics-to-best-practices-3fd69a8e458c
        // all of this has been merged to https://www.baeldung.com/lombok-builder @Builder annotaion
        SampleObjectUsingBuilder sampleObjectUsingBuilder = SampleObjectUsingBuilder
                .builder()
                .var1(1).var2(2).var3("3")
                .build();
        log.info("final object: " + sampleObjectUsingBuilder);
        // another way of printing
        // log.info("final object: {}", sampleObject);
        return sampleObject;
    }
}
