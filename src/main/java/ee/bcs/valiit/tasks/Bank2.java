package ee.bcs.valiit.tasks;

public class Bank2 {
    private int id;
    private String account;
    private String owner;
    private int balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

// BANKCONTROLLER
//package ee.bcs.valiit.tasks;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//
//@RequestMapping("bank")
//@RestController
//public class BankControllerOrig {
//
//    HashMap<String, BigDecimal> accountMap = new HashMap<>();
//
//    // http://localhost:8080/bank/createAccount?accountNr=EE123
//    // http://localhost:8080/bank/createAccount?accountNr=EE124
//    @GetMapping("createAccount")
//    public void createAccount(@RequestParam("accountNr") String accountNr) {
//        accountMap.put(accountNr, BigDecimal.ZERO);
//        System.out.println("A new account has been created with account nr " + accountNr);
//    }
//
//    // http://localhost:8080/bank/accountBalance?accountNr=EE123
//    @GetMapping("accountBalance")
//    public BigDecimal accountBalance(@RequestParam("accountNr") String accountNr) {
//        System.out.println("Account " + accountNr + "balance is currently " + accountMap.get(accountNr));
//        return accountMap.get(accountNr);
//    }
//
//    // http://localhost:8080/bank/depositMoney?accountNr=EE123&amount=50
//    @GetMapping("depositMoney")
//    public void depositMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
//        BigDecimal balance = accountMap.get(accountNr);
//        BigDecimal newBalance = balance.add(amount);
//        accountMap.put(accountNr, newBalance);
//        System.out.println("The amount " + amount + " was deposited to account nr " + accountNr + ", account balance is currently " + newBalance);
//    }
//
//    // http://localhost:8080/bank/withdrawMoney?accountNr=EE123&amount=30
//    @GetMapping("withdrawMoney")
//    public void withdrawMoney(@RequestParam("accountNr") String accountNr, @RequestParam("amount") BigDecimal amount) {
//        BigDecimal balance = accountMap.get(accountNr);
//        BigDecimal newBalance = balance.subtract(amount);
//        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("Not enough money");
//        }
//        accountMap.put(accountNr, newBalance);
//        System.out.println("The amount " + amount + " was withdrawn from account nr " + accountNr);
//    }
//
//    // http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=15
//    @GetMapping("transferMoney")
//    public void transferMoney(@RequestParam("fromAccount") String fromAccount,
//                              @RequestParam("toAccount") String toAccount,
//                              @RequestParam("amount") BigDecimal amount) {
//        BigDecimal fromAccountBalance = accountMap.get(fromAccount);
//        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
//        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
//            throw new RuntimeException("There is not enough money for this transaction.");
//        }
//        accountMap.put(fromAccount, newFromAccountBalance);
//        BigDecimal toAccountBalance = accountMap.get(toAccount);
//        BigDecimal newToAccountBalance = toAccountBalance.add(amount);
//        accountMap.put(toAccount, newToAccountBalance);
//        System.out.println("The amount " + amount + " was transferred to account nr " + toAccount + ", new balance is " + newFromAccountBalance);
//        System.out.println("The amount " + amount + " was transferred from account nr " + fromAccount + ", new balance of " + toAccount + " is " + newToAccountBalance);
//    }
//}


// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


// BANK_CONTROLLER
//package ee.bcs.valiit.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
//@RequestMapping("bank")
//@RestController
//public class Bank_Controller {
//
//    @Autowired
//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    HashMap<String, BigDecimal> accountMap = new HashMap<>();
//
//    // http://localhost:8080/bank/createAccount?accountNr=EE12340
//    @GetMapping("createAccount")
//    public void createAccount(@RequestParam("accountNr") String accountNr){
//        String sql = "INSERT INTO accounts (account_number, account_balance) VALUES (:accountNumber, :accountBalance)";
//        Map<String, Object> paramMap = new HashMap();
//        paramMap.put("accountNumber", accountNr);
//        paramMap.put("balance", BigDecimal.ZERO);
//        jdbcTemplate.update(sql, paramMap);
//    }
//
//
//}
//
//
//
////    // http://localhost:8080/bank/createAccount
////    @PostMapping("createAccount")
////    public void createAccount(@RequestBody String accountNumber) {
////        String sql = "INSERT INTO accounts (account_number, owner, account_balance) VALUES (:accountNr, :owner, :accountBalance)";
////        Map<String, Object> paramMap = new HashMap<>();
////        paramMap.put("accountNr", accountNumber);
////        paramMap.put("owner", "");
////        paramMap.put("accountBalance", BigDecimal.ZERO);
////        jdbcTemplate.update(sql, paramMap);
////    }
//
