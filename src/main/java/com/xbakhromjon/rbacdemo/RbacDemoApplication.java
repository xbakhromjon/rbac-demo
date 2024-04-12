package com.xbakhromjon.rbacdemo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class RbacDemoApplication implements CommandLineRunner {
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(RbacDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        displayAllBeans();
    }

    public static void displayAllBeans() {

    }
}
