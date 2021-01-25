package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {
//    String sql = "INSERT INTO accounts (account_number, account_balance) VALUES (:account, :balance)";
//    Map<String, Object> paramMap = new HashMap();

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(String accountNr) {
        accountRepository.createAccount(accountNr);
    }

    public BigDecimal viewAccountBalance(String accountNr) {
        return accountRepository.viewAccountBalance(accountNr);
    }

    public void depositMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = accountRepository.viewAccountBalance(accountNr);
        BigDecimal newAmount = balance.add(amount);
        accountRepository.updateAccountBalance(accountNr, newAmount);
    }

    public void withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = accountRepository.viewAccountBalance(accountNr);
        BigDecimal newAmount = balance.subtract(amount);
        if (newAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("You currently do not have sufficient funds for this operation. Please select an appropriate amount");
        }
    }



}
