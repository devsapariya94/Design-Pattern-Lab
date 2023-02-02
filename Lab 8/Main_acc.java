import java.util.HashMap;
import java.util.Map;

class Banker {
    private static Banker instance;
    private Map<Integer, BankAccount> accounts;
    
    private Banker() {
        accounts = new HashMap<>();
    }
    
    public static Banker getInstance() {
        if (instance == null) {
            instance = new Banker();
        }
        return instance;
    }
    
    public BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
    
    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }
}

class BankAccount {
    private int accountNumber;
    private double balance;
    
    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }
}

public class Main_acc{
    public static void main(String[] args) {
        Banker bank = Banker.getInstance();
        BankAccount account = new BankAccount(123);
        bank.addAccount(account);
        account.deposit(100);
        account.withdraw(50);
        System.out.println(bank.getAccount(123).getBalance());
        BankAccount account2 = new BankAccount(456);
        bank.addAccount(account2);
        account2.deposit(100);
        account2.withdraw(50);
        System.out.println(bank.getAccount(456).getBalance());
    }
}
