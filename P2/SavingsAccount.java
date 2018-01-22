/*
 CSE 17
 Zihan Liu
 zil317
 Program #2     DEADLINE: October 13, 2016
 Program Description: Simple Bank
 */

/**This class creates a savings account that is a subclass of bank account*/
public class SavingsAccount extends BankAccount{
  /**create a private double interestRate*/
  private double interestRate;
  
  /**create a new savings account with the given account number, customer, balance, and interest rate*/
  public SavingsAccount(int accountNum, String customerName, double balance, double interestRate){
    super(accountNum,customerName,balance);
    this.interestRate = interestRate;
  }
    
  /**create a new saving account with the given parameters, initializing the balance to 0*/
  public SavingsAccount(int accountNum, String customerName, double interestRate){
    super(accountNum, customerName);
    this.interestRate = interestRate;
    balance = 0;
  }
  
  /**get method for interestRate*/
  public double getInterestRate(){
    return interestRate;
  }
  
  /**adds interestRate*balance to the balance*/
  public void accrueInterest(){
    balance += interestRate*balance;
  }
  
  /**prints information about the account to the screen*/
  public void printAccountInfo(){
    System.out.printf("%-5d %-20s %10.2f   %-10s %-1.1f%%\n", getAccountNum(), getCustomerName(), getBalance(),"Interest Rate: ", getInterestRate()*100);
  }
} 
  