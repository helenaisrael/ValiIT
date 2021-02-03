package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("bank3")
@RestController
public class Bank3Controller {

    @Autowired
    private Bank3Service bank3Service;

    // http://localhost:8080/bank3/createCustomer?firstName=Mari&lastName=Maasikas&birthDate=04/10/1990&phone=+37265645456&email=test@mail.ee
    // http://localhost:8080/bank3/createCustomer?firstName=Mikk&lastName=Mustikas&birthDate=15/03/1967&phone=+372125454&email=testmail@test.ee
    // http://localhost:8080/bank3/createCustomer?firstName=Laura&lastName=Leesikas&birthDate=22/07/1978&phone=+37254889854&email=laura.leesikas@email.com
    // http://localhost:8080/bank3/createCustomer?firstName=Tige&lastName=Tikker&birthDate=17/01/1982&phone=+3726777699&email=tige@tikker.ee
    @PostMapping("createCustomer")
    public void createCustomer(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("birthDate") String birthDate,
                               @RequestParam("phone") String phone,
                               @RequestParam("email") String email) {
        bank3Service.createCustomer(firstName, lastName, birthDate, phone, email);
    }

    // http://localhost:8080/bank3/createAccount?accountNr=EE001&owner=1
    // http://localhost:8080/bank3/createAccount?accountNr=EE002&owner=2
    @PostMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String accountNr, @RequestParam("owner") Integer owner) {
        bank3Service.createAccount(accountNr, owner);
    }

    // http://localhost:8080/bank3/accountBalance?accountNr=EE001
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
        return bank3Service.accountBalance(accountNr);
    }

    // http://localhost:8080/bank3/depositMoney?accountNr=EE001&amount=50
    @PutMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bank3Service.depositMoney(accountNr, amount);
//        bank3Service.accountHistory(deposited, withdrawn, incomes, fromAccountId, outgoings, toAccountId);
    }

    // http://localhost:8080/bank3/withdrawMoney?accountNr=EE001&amount=20
    // http://localhost:8080/bank3/withdrawMoney?accountNr=EE001&amount=60  <<< testcase for exception
    @PutMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
        bank3Service.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8080/bank3/transferMoney?fromAccount=EE001&toAccount=EE002&amount=10
    // http://localhost:8080/bank3/transferMoney?fromAccount=EE001&toAccount=EE002&amount=100  <<< testcase for exception
    @PutMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        bank3Service.transferMoney(fromAccount, toAccount, amount);
    }

//    // http://localhost:8080/bank3/accountHistory?accountNr=EE001
//    @GetMapping("accountHistory")
//    public void accountHistory(@RequestParam("accountNr") String accountNr) {
//        return bank3Service.accountHistory(accountNr);
//    }

}
