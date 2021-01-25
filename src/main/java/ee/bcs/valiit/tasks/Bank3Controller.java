package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank3")
@RestController
public class Bank3Controller {

    @Autowired
    private Bank3Service bank3Service;

    // http://localhost:8080/bank3/createAccount?accountNr=EE110
    // http://localhost:8080/bank3/createAccount?accountNr=EE200
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr) {
        bank3Service.createAccount(accountNr);
    }

    // http://localhost:8080/bank3/accountBalance?accountNr=EE111
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        return bank3Service.accountBalance(accountNr);
    }

    // http://localhost:8080/bank3/depositMoney?accountNr=EE111&amount=25
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bank3Service.depositMoney(accountNr, amount);
    }

    // http://localhost:8080/bank3/withdrawMoney?accountNr=EE111&amount=10
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bank3Service.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8080/bank3/transferMoney?fromAccount=EE111&toAccount=EE222&amount=5
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        bank3Service.transferMoney(fromAccount, toAccount, amount);
    }
}
