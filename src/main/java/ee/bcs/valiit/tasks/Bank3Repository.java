package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Bank3Repository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr) {
        String sql = "INSERT INTO accounts (account_number, account_balance) VALUES (:accountNumber, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
        //accountMap.put(accountNr, BigDecimal.ZERO);
    }

    public BigDecimal accountBalance(String accountNr) {
        String sql = "SELECT account_balance FROM accounts WHERE account_number = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        // return accountMap.get(accountNr);
    }

    public void transaction(String accountNr, BigDecimal newBalance) {
        // accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE accounts SET account_balance = :balance WHERE account_number = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }
}


//    public BigDecimal depositMoney(String accountNr, BigDecimal amount) {
//        // BigDecimal balance = accountMap.get(accountNr);
//        String sql = "SELECT account_balance FROM accounts WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//    }
//
//    public BigDecimal withdrawMoney(String accountNr, BigDecimal amount) {
//        //BigDecimal balance = accountMap.get(accountNr);
//        String sql = "SELECT account_balance FROM accounts where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//    }
//
//    public BigDecimal transferMoney1(String fromAccount, BigDecimal amount) {
//        // BigDecimal fromAccountBalance = accountMap.get(fromAccount);
//        String sql = "SELECT account_balance FROM accounts where account_number = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", fromAccount);
//        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//    }
//
//    public void transferMoney2(String fromAccount, BigDecimal amount) {
//        // accountMap.put(fromAccount, newFromAccountBalance);
//        String sql2 = "UPDATE accounts SET account_balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap2 = new HashMap();
//        paramMap2.put("accountNumber", fromAccount);
//        paramMap2.put("balance", amount);
//        jdbcTemplate.update(sql2, paramMap2);
//    }
//
//    public BigDecimal transferMoney3(String toAccount, BigDecimal amount) {
//        // BigDecimal toAccountBalance = accountMap.get(toAccount);
//        String sql3 = "SELECT account_balance FROM accounts where account_number = :accountNumber";
//        Map<String, Object> paramMap3 = new HashMap<>();
//        paramMap3.put("accountNumber", toAccount);
//        return jdbcTemplate.queryForObject(sql3, paramMap3, BigDecimal.class);
//    }
//
//    public void transferMoney4(String toAccount, BigDecimal amount) {
//        // accountMap.put(toAccount, newToAccountBalance);
//        String sql4 = "UPDATE accounts SET account_balance = :balance WHERE account_number = :accountNumber";
//        Map<String, Object> paramMap4 = new HashMap();
//        paramMap4.put("accountNumber", toAccount);
//        paramMap4.put("balance", amount);
//        jdbcTemplate.update(sql4, paramMap4);
//    }
