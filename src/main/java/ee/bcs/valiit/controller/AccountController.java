package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank2")
@RestController
public class AccountController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountService accountService;

    // http://localhost:8080/bank2/createAccount?accountNr=EE12340
    @GetMapping("createAccount")
    public String createAccount(@RequestParam("accountNr") String accountNr){
        accountService.createAccount(accountNr);
        return "Success! You have just created a new bank account, please memorize your account number: " + accountNr;
    }


    // http://localhost:8080/bank2/accountBalance?accountNr=EE12340
    @GetMapping("accountBalance")
    public String accountBalance(@RequestParam("accountNr") String accountNr){
       accountService.viewAccountBalance(accountNr);
       return "Your account balance is currently " + accountBalance(accountNr) + "$";
    }


    // http://localhost:8080/bank2/depositMoney?accountNr=EE12340&amount=25
    @GetMapping("depositMoney")
    public String depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount){
        accountService.depositMoney(accountNr, amount);
        return "Success! You have just deposited " + amount + "$ to your bank account " + accountNr;
    }


    // http://localhost:8080/bank2/withdrawMoney?accountNr=EE12340&amount=30
    @GetMapping("withdrawMoney")
    public String withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
//        String sql = "SELECT account_balance FROM accounts where account_number = :account";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("account", accountNr);
//        BigDecimal balance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//
//        BigDecimal newAmount = balance.subtract(amount);
//        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("You currently do not have sufficient funds for this operation. Please select an appropriate amount");
//        }
//
//        String sql2 = "UPDATE accounts SET account_balance = :balance WHERE account_number = :accountNr";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNr", accountNr);
//        paramMap2.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap2);
//        accountService...
        return "Success! Please take your money and proceed";
    }


    // http://localhost:8080/bank2/transferMoney?fromAccount=EE12340&toAccount=EE123&amount=100
    @GetMapping("transferMoney")
    public String transferMoney(@RequestParam("fromAccount") String fromAccount,
                              @RequestParam("toAccount") String toAccount,
                              @RequestParam("amount") BigDecimal amount){

        String sql = "SELECT account_balance FROM accounts where account_number = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", fromAccount);
        BigDecimal fromAccountBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);

        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if(newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("You currently do not have sufficient funds for this operation. Please select an appropriate amount");
        }

        // muudab accountMap'is fromAccount kontojäägi
        String sql2 = "UPDATE accounts SET account_balance = :balance WHERE account_number = :accountNr";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNr", fromAccount);
        paramMap2.put("balance", newFromAccountBalance);
        jdbcTemplate.update(sql2, paramMap2);

        String sql3 = "SELECT account_balance FROM accounts where account_number = :accountNr";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("accountNr", toAccount);
        BigDecimal toAccountBalance = jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);

        BigDecimal newToAccountBalance = toAccountBalance.add(amount);

        // muudab accountMap'is toAccount kontojäägi
        String sql4 = "UPDATE accounts SET account_balance = :balance WHERE account_number = :accountNr";
        Map<String, Object> paramMap4 = new HashMap();
        paramMap4.put("accountNr", toAccount);
        paramMap4.put("balance", newToAccountBalance);
        jdbcTemplate.update(sql4, paramMap4);
        return "The amount " + amount + "$ was successfully transferred to account " + toAccount;
    }
}





































//    // http://localhost:8080/bank/createAccount
//    @PostMapping("createAccount")
//    public void createAccount(@RequestBody String accountNumber) {
//        String sql = "INSERT INTO accounts (account_number, owner, account_balance) VALUES (:accountNr, :owner, :accountBalance)";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNr", accountNumber);
//        paramMap.put("owner", "");
//        paramMap.put("accountBalance", BigDecimal.ZERO);
//        jdbcTemplate.update(sql, paramMap);
//    }


