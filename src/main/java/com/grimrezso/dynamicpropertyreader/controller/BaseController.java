package com.grimrezso.dynamicpropertyreader.controller;

import com.grimrezso.dynamicpropertyreader.controller.config.PropertyConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

public class BaseController {
    @Value("${test.local}")
    static String local;

    @GetMapping("/dynamicProperty")
    public static String welcome(){
        System.out.println(PropertyConfig.customProperty.getProperty("test.mobile"));
        System.out.println(PropertyConfig.customProperty.getProperty("test.pet"));
        System.out.println(local);
        System.out.println();
        return PropertyConfig.customProperty.getProperty("test.name");
    }
}
