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

    public void createAccount(String accountNr, Integer owner) {
        String sql = "INSERT INTO accounts (account_nr, customer_id, account_balance) VALUES (:accountNumber, :owner, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("owner", owner);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
        //accountMap.put(accountNr, BigDecimal.ZERO);
    }

    public BigDecimal accountBalance(String accountNr) {
        String sql = "SELECT account_balance FROM accounts WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        // return accountMap.get(accountNr);
    }

    public void transaction(String accountNr, BigDecimal newBalance) {
        // accountMap.put(accountNr, newBalance);
        String sql2 = "UPDATE accounts SET account_balance = :balance WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNr);
        paramMap2.put("balance", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public void createCustomer(String firstName, String lastName, String birthDate, String phone, String email) {
        String sql = "INSERT INTO customers (first_name, last_name, birth_date, phone, email) VALUES (:firstName, :lastName, :birthDate, :phone, :email)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);
        paramMap.put("birthDate", birthDate);
        paramMap.put("phone", phone);
        paramMap.put("email", email);
        jdbcTemplate.update(sql, paramMap);

    }
}


