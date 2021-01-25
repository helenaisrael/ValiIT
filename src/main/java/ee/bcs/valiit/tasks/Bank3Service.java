package ee.bcs.valiit.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
        BigDecimal balance = bank3Repository.accountBalance(accountNr);
        BigDecimal newBalance = balance.add(amount);
        bank3Repository.transaction(accountNr, newBalance);
    }

    public void withdrawMoney(String accountNr, BigDecimal amount) {
        BigDecimal balance = bank3Repository.accountBalance(accountNr);
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bank3Repository.transaction(accountNr, newBalance);
    }

    public void transferMoney(String fromAccount, String toAccount, BigDecimal amount) {
        BigDecimal fromAccountBalance = bank3Repository.accountBalance(fromAccount);
        BigDecimal newFromAccountBalance = fromAccountBalance.subtract(amount);
        if (newFromAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money");
        }
        bank3Repository.accountBalance(fromAccount); // transferMoney1
        bank3Repository.transaction(fromAccount, newFromAccountBalance); // transferMoney2

        BigDecimal toAccountBalance = bank3Repository.accountBalance(toAccount);
        BigDecimal newToAccountBalance = toAccountBalance.add(amount);
        bank3Repository.accountBalance(toAccount); // transferMoney3
        bank3Repository.transaction(toAccount, newToAccountBalance); // transferMoney4
    }
}
