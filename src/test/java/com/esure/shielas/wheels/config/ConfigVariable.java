package com.esure.shielas.wheels.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConfigVariable {

    @Value("${env.tester}")
    private String tester;

    @Value("${env.url}")
    private String url;

}
