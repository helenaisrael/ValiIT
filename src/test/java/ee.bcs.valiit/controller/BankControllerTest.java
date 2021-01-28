package ee.bcs.valiit.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void createAccount() throws Exception {
        mockMvc.perform(get("/bank2/createAccount?accountNr=EE123")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}