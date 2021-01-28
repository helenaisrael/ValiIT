package ee.bcs.valiit.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MathUtil_ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void max() {
//        mockMvc.perform(get("Lesson1MathUtil/min1?a=5&b=9")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
    }

    @Test
    void abs() {
    }

    @Test
    void isEven() {
    }

    @Test
    void min() {
    }

    @Test
    void testMax() {
    }
}