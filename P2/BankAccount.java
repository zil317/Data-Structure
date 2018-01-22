/*
 CSE 17
 Zihan Liu
 zil317
 Program #2     DEADLINE: October 13, 2016
 Program Description: Simple Bank
 */

/**This class creates a bank account*/
public class BankAccount{
  /**create int accuntNum, String customerName, double balance*/
  int accountNum;
  String customerName;
  double balance;
  
  /**create a bank account with given account number, customer, and balance*/
  public BankAccount(int accountNum, String customerName, double balance){
     this.accountNum = accountNum;
     this.customerName = customerName;
     this.balance = balance;
  }
  
  /**creaet a new bank account with the given parameters, initializing the balance to 0*/
  public BankAccount(int accountNum, String customerName){
    this(accountNum,customerName,0); 
  }
  
  /**get method for accountNum*/
  public int getAccountNum(){
    return accountNum;
  }
  
  /**get method for customerName*/
  public String getCustomerName(){
    return customerName;
  }
  
  /**get method for balance*/
  public double getBalance(){
    return balance;
  }
  
  /**add depositeAmt to the account's balance*/
  public void makeDeposit(double depositAmt){
    balance = balance + depositAmt;
  }
  
  /**prints information about the account to the screen*/
  public void printAccountInfo(){
    System.out.printf("%-5d %-20s   %10.2f",getAccountNum(), getCustomerName(), getBalance());
  }
}
  
      
      
      
      
      
      