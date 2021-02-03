package ee.bcs.valiit.tasks.bank;

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

    public String findPassWordByUserName(String username) {
        String sql = "SELECT password FROM customers WHERE username=:username";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    public void createAccount(String accountNr, Integer owner) {
        String sql = "INSERT INTO accounts (account_nr, customer_id, account_balance) VALUES (:accountNumber, :owner, :balance)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("owner", owner);
        paramMap.put("balance", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public void getAccountId(Integer accountId) {
        String sql = "SELECT id FROM accounts WHERE customer_Id=:customerId";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountId", accountId);
        jdbcTemplate.update(sql, paramMap);
    }

    public BigDecimal accountBalance(String accountNr) {
        String sql = "SELECT account_balance FROM accounts WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public void transactions(String accountNr, BigDecimal newBalance) {
        String sql = "UPDATE accounts SET account_balance = :balance WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);

//        String sql2 = "UPDATE transactions SET from_account_id = :fromAccountId WHERE account_nr = :accountNumber";
//        Map<String, Object> paramMap3 = new HashMap();
//        paramMap3.put("accountNumber", accountNr);
//        paramMap3.put("balance", newBalance);
//        jdbcTemplate.update(sql2, paramMap3);
    }

//    public void accountHistory(Integer accountId, BigDecimal cashAmount) {
//
//    }
//
//    public void accountHistory(String accountNr, BigDecimal withdrawn, ) {
//
//    }

    public void accountHistory(BigDecimal deposited, BigDecimal withdrawn, BigDecimal incomes, Integer fromAccountId, BigDecimal outgoings, Integer toAccountId) {
        String sql = "INSERT INTO transactions (cash_deposited, cash_withdrawn, transfers_in, from_account_id, transfers_out, to_account_id) " +
                     "VALUES (:deposited, :withdrawn, :transfersIn, :fromAccountId, :transfersOut, :toAccountId)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("deposited", deposited);
        paramMap.put("withdrawn", withdrawn);
        paramMap.put("transfersIn", incomes);
        paramMap.put("fromAccountId", fromAccountId);
        paramMap.put("transfersOut", outgoings);
        paramMap.put("toAccountId", toAccountId);
        jdbcTemplate.update(sql, paramMap);
    }

//    public void accountHistory(String AccountNr) {
//        String sql = "SELECT account_balance FROM accounts WHERE account_nr = :accountNumber";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("accountNumber", accountNr);
//        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//    }

//    public void accountHistory(BigDecimal amount) {
//        String sql = "INSERT INTO transactions (cash_deposited) VALUES (:deposited)";
//        Map<String, Object> paramMap = new HashMap();
//        paramMap.put("deposited", amount);
//        jdbcTemplate.update(sql, paramMap);
//    }

    // String sql = "SELECT * FROM accounts ";
}


