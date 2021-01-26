package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("bank3")
@RestController
public class Bank3Controller {

    @Autowired
    private Bank3Service bank3Service;

    // http://localhost:8080/bank3/createAccount?accountNr=EE001&owner=1
    // http://localhost:8080/bank3/createAccount?accountNr=EE002&owner=2
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr, @RequestParam("owner") Integer owner) {
        bank3Service.createAccount(accountNr, owner);
    }

    // http://localhost:8080/bank3/accountBalance?accountNr=EE001
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        return bank3Service.accountBalance(accountNr);
    }

    // http://localhost:8080/bank3/depositMoney?accountNr=EE001&amount=50
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bank3Service.depositMoney(accountNr, amount);
    }

    // http://localhost:8080/bank3/withdrawMoney?accountNr=EE001&amount=20
    // http://localhost:8080/bank3/withdrawMoney?accountNr=EE001&amount=60  <<< testcase for exception
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bank3Service.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8080/bank3/transferMoney?fromAccount=EE001&toAccount=EE002&amount=10
    // http://localhost:8080/bank3/transferMoney?fromAccount=EE001&toAccount=EE002&amount=100  <<< testcase for exception
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        bank3Service.transferMoney(fromAccount, toAccount, amount);
    }

    // http://localhost:8080/bank3/createCustomer?firstName=Ago&lastName=Alev&birthDate=1990&phone=+37265645456&email=test@mail.ee
    @GetMapping("createCustomer")
    public void createNewCustomer(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName,
                                  @RequestParam("birthDate") String birthDate,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("email") String email) {
        bank3Service.createCustomer(firstName, lastName, birthDate, phone, email);
    }
}
