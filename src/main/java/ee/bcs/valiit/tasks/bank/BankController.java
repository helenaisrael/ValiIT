package ee.bcs.valiit.tasks.bank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("bank")
@RestController
public class BankController {

    HashMap<String, BigDecimal> accountMap = new HashMap<>();

    // http://localhost:8080/bank/createAccount?accountNr=EE123
    // http://localhost:8080/bank/createAccount?accountNr=EE124
    @GetMapping("createAccount")
    public void createAccount(@RequestParam("accountNr") String account) {
        accountMap.put(account, BigDecimal.ZERO);
        System.out.println("A new account has been created with account nr " + account + ". " +
                "Currently account balance is " + BigDecimal.ZERO + "$ \n");
    }

    // http://localhost:8080/bank/accountBalance?accountNr=EE123
    @GetMapping("accountBalance")
    public BigDecimal accountBalance(@RequestParam("accountNr") String account) {
        System.out.println("Account " + account + " balance is currently " + accountMap.get(account) + "$ \n");
        return accountMap.get(account);
    }

    // http://localhost:8080/bank/depositMoney?accountNr=EE123&amount=50
    @GetMapping("depositMoney")
    public void depositMoney(@RequestParam("accountNr") String account, @RequestParam("amount") BigDecimal amount) {
        BigDecimal balance = accountMap.get(account);
        BigDecimal newBalance = balance.add(amount);
        accountMap.put(account, newBalance);
        System.out.println("The amount " + amount + "$ was deposited to account nr " + account + ", " +
                "account balance is currently " + newBalance + "$ \n");
    }

    // http://localhost:8080/bank/withdrawMoney?accountNr=EE123&amount=20
    @GetMapping("withdrawMoney")
    public void withdrawMoney(@RequestParam("accountNr") String account, @RequestParam("amount") BigDecimal amount) {
        BigDecimal balance = accountMap.get(account);
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("There is not enough money for this transaction \n");
            throw new RuntimeException("There is not enough money for this transaction");
        }
        accountMap.put(account, newBalance);
        System.out.println("The amount " + amount + "$ was withdrawn from account nr " + account +"\n");
    }

    // http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=15
    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount) {
        BigDecimal fromAccountBalance = accountMap.get(fromAccount);
        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("There is not enough money for this transaction \n");
            throw new RuntimeException("There is not enough money for this transaction");
        }
        accountMap.put(fromAccount, newFromAccountBalance);
        BigDecimal toAccountBalance = accountMap.get(toAccount);
        BigDecimal newToAccountBalance = toAccountBalance.add(amount);
        accountMap.put(toAccount, newToAccountBalance);
        System.out.println("The amount " + amount + " was transferred to account nr " + toAccount + ", " +
                "new balance is " + newFromAccountBalance + "$");
        System.out.println("The amount " + amount + " was transferred from account nr " + fromAccount + ", " +
                "new balance of " + toAccount + " is " + newToAccountBalance + "$ \n");
    }
}
