package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr) {
        String sql = "INSERT INTO accounts (account_number, account_balance) VALUES (:account, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("account", accountNr);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal viewAccountBalance(String accountNr) {
        String sql = "SELECT account_balance FROM accounts WHERE account_number = :account";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }
    String sql = "SELECT account_balance FROM accounts WHERE account_number = :account";

    public void updateAccountBalance(String accountNr, BigDecimal newAmount) {
        String sql2 = "UPDATE accounts SET account_balance = :balance WHERE account_number = :account";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("accountNr", accountNr);
        paramMap2.put("balance", newAmount);
        jdbcTemplate.update (sql2, paramMap2);
    }




}
