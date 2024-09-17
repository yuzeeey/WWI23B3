package de.rinderle.dhbw.wwi23b3;

import org.springframework.boot.SpringApplication;

public class TestKaWwi23B3Application {

    public static void main(String[] args) {
        SpringApplication.from(KaWwi23B3Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
