package com.esure.shielas.wheels.annotation;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:cucumber.xml"})
@SpringBootTest
public @interface SpringTestAnnotation {
}
