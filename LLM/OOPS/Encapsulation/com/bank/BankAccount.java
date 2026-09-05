package LLM.OOPS.Encapsulation.com.bank;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolder;


    public BankAccount(String accountNumber, double initialBalance, String accountHolder) {
        this.accountNumber = accountNumber;
        if (initialBalance >=0){
            this.balance = initialBalance;
        }else {
            this.balance  = 0;
        }
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder){
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        }
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposited " + amount );
        }else {
            System.out.println("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount){
        if (amount > 0){
            balance -= amount;
            System.out.println("Withdrew " + amount );
        }else if(amount > balance){
            System.out.println("Insufficient balance");
        }else {System.out.println("Withdrawal amount must be positive");System.out.println("Invalid withdrawal amount");
        }
    }
}
