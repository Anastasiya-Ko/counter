package kopylva.counter.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CounterServiceTest {

    @Autowired
    CounterService service;

    @Test
    void readTest() {
        String text = "aaadd";
        assertEquals(service.read(text), "\"a\": 3, \"d\": 2");
    }

}