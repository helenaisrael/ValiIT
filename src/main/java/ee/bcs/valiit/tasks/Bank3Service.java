package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class Bank3Service {

    @Autowired
    private Bank3Repository bank3Repository;

    public void createAccount(String accountNr) {
        bank3Repository.createAccount(accountNr);
    }

    public BigDecimal accountBalance(String accountNr) {
        return bank3Repository.accountBalance(accountNr);
    }

    public void depositMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bank3Repository.depositMoney(accountNr, amount);
        BigDecimal newBalance = balance.add(amount);
        bank3Repository.updateBalance(accountNr, newBalance);
    }

    public void withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bank3Repository.withdrawMoney(accountNr, amount);
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bank3Repository.updateBalance(accountNr, newBalance);
    }

    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {
        BigDecimal fromAccountBalance = bank3Repository.accountBalance(fromAccount);
        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bank3Repository.transferMoney(fromAccount, amount);
        bank3Repository.transferMoney2(fromAccount, newFromAccountBalance);
        BigDecimal toAccountBalance = bank3Repository.accountBalance(toAccount);
        BigDecimal newToAccountBalance = toAccountBalance.add(amount);
        bank3Repository.transferMoney3(toAccount, amount);
        bank3Repository.transferMoney4(toAccount, newToAccountBalance);
    }
}
