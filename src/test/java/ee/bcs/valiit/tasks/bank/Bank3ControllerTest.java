package ee.bcs.valiit.tasks.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class Bank3ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void createCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bank3/createCustomer?firstName=Kaval&lastName=Rebane&birthDate=17/03/1981&phone=+3726777699&email=kaval@rebane.ee")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bank3/createAccount?accountNr=EE009&owner=6")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void accountBalance() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/bank3/accountBalance?accountNr=EE001")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void depositMoney() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/bank3/depositMoney?accountNr=EE001&amount=50")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void withdrawMoney() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/bank3/withdrawMoney?accountNr=EE001&amount=20")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void transferMoney() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/bank3/transferMoney?fromAccount=EE002&toAccount=EE001&amount=10")
                .contentType("application/json"))                                         
                .andExpect(status().isOk());                                              
    }
}