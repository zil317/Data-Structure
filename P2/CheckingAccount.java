/*
 CSE 17
 Zihan Liu
 zil317
 Program #2     DEADLINE: October 13, 2016
 Program Description: Simple Bank
 */

/**This class creates a checking account that is a subclass of bank account*/
public class CheckingAccount extends BankAccount{
  
  /**create a private double field monthlyFee*/
  private double monthlyFee;
  
  /**create a new checking account with the given account number, customer, balance and monthlyFee*/
  public CheckingAccount(int accountNum, String customerName, double balance, double monthlyFee){
    super(accountNum,customerName,balance);
    this.monthlyFee = monthlyFee; 
  }
  
  /**get method for monthlyFee*/
  public double getMonthlyFee(){
    return monthlyFee;
  }
  
  /**set method for monthlyFee*/
  public void setMonthlyFee(double monthlyFee){
    monthlyFee=monthlyFee;
  }
  
  /**substracts monthlyFee from the balance*/
  public void applyFee(){
    balance = balance - monthlyFee;
  }
  
  /**print information about the account to the screen*/
  public void printAccountInfo(){
    System.out.printf("%-5d %-20s %10.2f   %-10s %-2.2f\n",getAccountNum(), getCustomerName(), getBalance(),"Monthly fee: $",getMonthlyFee());
  }
}
  
  
    
  