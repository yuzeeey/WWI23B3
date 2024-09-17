package de.rinderle.dhbw.wwi23b3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class KaWwi23B3ApplicationTests {

    @Test
    void contextLoads() {
    }

}
