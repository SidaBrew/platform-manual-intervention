package com.zenki.dataplus.pmi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zenki.dataplus.pmi.dao.generated.mappper")
public class PlatformManualInterventionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformManualInterventionApplication.class, args);
    }

}
