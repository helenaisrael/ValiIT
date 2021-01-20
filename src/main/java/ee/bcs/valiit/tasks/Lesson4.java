package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type \"help\" for the list of commands.");
        while (true) {
            System.out.println("Please enter a command: ");
            String command = scanner.nextLine(); // commandi sisendiks on käsklus skännerist
            String[] commandParts = command.split(" "); // createAccount EE123x //command split teeb tühiku kohalt pooleks
            if (command.equalsIgnoreCase("exit")) { // kui algse sisendi sees on exit, siis programm läheb kinni
                break;
            }

            else if (commandParts[0].equalsIgnoreCase("help")) { // ignorecase >> pole vahet, kas upper/lower case
                System.out.println("createAccount ${accountNr}");
                System.out.println("getBalance ${accountNr}");
                System.out.println("depositMoney ${accountNr} ${amount}");
                System.out.println("withdrawMoney ${accountNr} ${amount}");
                System.out.println("transferMoney ${fromAccount} ${toAccount} ${amount}\n"); // \n lisab tühja rea!
            }

            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance

            else if (commandParts[0].equalsIgnoreCase("createAccount")) { // kui command osa indexil 0 (käsklus), siis
                accountBalanceMap.put(commandParts[1], new BigDecimal("0")); // paneb hashmapi command index1 (kontonr) key'ks & BigDecimal valueks 0
            }

            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific account

            else if (commandParts[0].equalsIgnoreCase("getBalance")) {
                System.out.println(accountBalanceMap.get(commandParts[1]));
            }

            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number

            else if (commandParts[0].equalsIgnoreCase("depositMoney")) {
                if (Integer.parseInt(commandParts[2]) > 0) { // muudan commandPart[2] numbri Stringist int'iks ja kontrollin, et oleks >0
                    BigDecimal depositAmount = new BigDecimal(commandParts[2]); // teen ajutiselt uue muutuja, võtab commandPart2 väärtuse, nt 10
                    BigDecimal accountBalance = accountBalanceMap.get(commandParts[1]); // võtan olemasoleva konto väärtuse
                    BigDecimal newBalance = accountBalance.add(depositAmount); // liidan kokku konto vana seisu + uue sissemakse
                    accountBalanceMap.put(commandParts[1], newBalance);
                } else {
                    System.out.println("The entered amount is invalid.");
                }
            }

            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative

            else if (commandParts[0].equalsIgnoreCase("withdrawMoney")) {
                if (Integer.parseInt(commandParts[2]) > 0) { // muudan commandPart[2] numbri Stringist int'iks ja kontrollin, et oleks >0
                    BigDecimal withdrawAmount = new BigDecimal(commandParts[2]); // teen ajutiselt uue muutuja, võtab commandPart2 väärtuse, nt 10
                    BigDecimal accountBalance = accountBalanceMap.get(commandParts[1]); // võtan olemasoleva konto väärtuse
                    BigDecimal newBalance = accountBalance.subtract(withdrawAmount); // lahutan kontojäägist väljavõetava numbri
                    if (newBalance.intValue() > 0) { // intValue muudab BigDecimali intiks, et saaksin võrdluse teha
                        accountBalanceMap.put(commandParts[1], withdrawAmount);
                    } else {
                        System.out.println("There is not enough money on this account.");
                    }
                } else {
                    System.out.println("The entered amount is invalid.");
                }
            }

            // TODO 5
            // Add command: "transferMoney ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction

            else if (commandParts[0].equalsIgnoreCase("transferMoney")) {
                if (Integer.parseInt(commandParts[2]) > 0) { // muudan commandPart[2] numbri Stringist int'iks ja kontrollin, et oleks >0
                    BigDecimal transferAmount = new BigDecimal(commandParts[3]); // teen ajutiselt uue muutuja, võtab commandPart2 väärtuse, nt 10
                    BigDecimal accountBalance = accountBalanceMap.get(commandParts[1]); // võtan olemasoleva konto väärtuse
                    BigDecimal newBalance = accountBalance.subtract(transferAmount); // lahutan kontojäägist välja võetava numbri

                    if (newBalance.intValue() > 0) { // intValue muudab BigDecimali intiks, et saaksin võrdluse teha
                        accountBalanceMap.put(commandParts[1], transferAmount);
                    } else {
                        System.out.println("There is currently not enough money on " + commandParts[1] + " account for this transaction.");
                    }
                } else {
                    System.out.println("The entered amount is invalid.");
                }
            }

            // TODO lisaülesanne - valideeri sisend
            // Nt kui sisend on EEE123, siis

            else {
                System.out.println("Unknown command");
            }
        }
    }
}
