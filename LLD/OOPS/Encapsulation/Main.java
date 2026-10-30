package LLM.OOPS.Encapsulation;


import LLM.OOPS.Encapsulation.com.bank.BankAccount;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Govinda Bank");
        BankAccount account = new BankAccount("123456789", 1000.0, "Govinda Ekabote");
        System.out.println( "Account Holder: "+ account.getAccountHolder());
        System.out.println("Balance: " +account.getBalance());
        System.out.println("Account Number: "+account.getAccountNumber());
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println(account.getBalance());
    }
}