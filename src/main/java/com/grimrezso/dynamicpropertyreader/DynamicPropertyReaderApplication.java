package com.grimrezso.dynamicpropertyreader;

import com.grimrezso.dynamicpropertyreader.controller.BaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicPropertyReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicPropertyReaderApplication.class, args);
        BaseController.welcome();
    }

}
