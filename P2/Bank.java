/*
 CSE 17
 Zihan Liu
 zil317
 Program #2     DEADLINE: October 13, 2016
 Program Description: Simple Bank
 */

/**This class creates a bank and stores user information into bank accounts*/
import java.util.Scanner;
import java.io.File;

public class Bank{
  /**create a private string field name and a private array of BankAccount objects called accounts, 
    * a private int field total Accounts and a final int MAX_ACCOUNTS = 20 */
  private String name;
  private BankAccount[] accounts;
  private int totalAccounts;
  public final int MAX_ACCOUNTS = 20;
  
  /**create a new bank with the given name 
    * Initialize its totalAccounts to 0 and make accounts to be size MAX_ACCOUNTS*/
  public Bank(String name){
    this.name = name;
    totalAccounts = 0;
    accounts = new BankAccount[MAX_ACCOUNTS];
  }
  
  /**get method for back name*/
  public String getName(){
    return name;
  }
  
  /**add the given account to accounts and update total accounts accordingly*/
  public void addAccount(BankAccount newAcct){
    accounts[totalAccounts] = newAcct;
    totalAccounts++;
  }
  
  /**print the bank name and information about each account, using appropriate printAccountInfo method, with one account per line*/
  public void printBankSunmmary(){
    for(int i=0; i<totalAccounts; i++){
      accounts[i].printAccountInfo();
    }
  }
  
  /**accrue one month's interest to each savings account, using its interestRate*/
  public void accrueInterestToSavingsAccounts(){
    for(int i=0; i<totalAccounts; i++){
      SavingsAccount save = null;
      if(accounts[i] instanceof SavingsAccount){
        save = (SavingsAccount) accounts[i];
         save.accrueInterest();
      } 
    }
  }
  
  /**subtract the monthlyFee from the balance of each CheckingAccount*/
  public void applyFeesToCheckingAccounts(){
    for(int i=0; i<totalAccounts; i++){
      CheckingAccount check=null;
      if(accounts[i] instanceof CheckingAccount){
        check = (CheckingAccount) accounts[i];
        check.applyFee();
      }
    }
  }
  
  /**Open a Scanner on acctFile, and for each line, create a checking or savings account, and add the accounts to the bank*/
  public void loadAccountsFromFile(File acctFile) throws Exception{
    Scanner scan = new Scanner(acctFile).useDelimiter("\\t|[\\n\\r\\f]+");
    
    while (scan.hasNext()) {
      String x = scan.next();
      BankAccount newAccount = null;
      if (x.equals("S")){
        int a = scan.nextInt();
        String b = scan.next();
        double c = scan.nextDouble();
        String D = scan.next();
        double d = Double.parseDouble(D);
        newAccount = new SavingsAccount(a,b,c,d);
      }
      
      else if(x.equals("C")){
        int a = scan.nextInt();
        String b = scan.next();
        double c = scan.nextDouble();
        String D = scan.next();
        double d = Double.parseDouble(D);
        newAccount = new CheckingAccount(a,b,c,d);
      }
      
      addAccount(newAccount);
    }
     scan.close();
  }
  
  /**create a main methods to print out user information*/
  public static void main (String[] args) throws Exception{
    //check if there is exactly one command-line argument, and exits with a user-friendly message if not
    if(args.length != 1){
      System.out.println("Usage:java Document filename");
      System.exit(0);
    }
      
   File file = new File(args[0]);
    
    //create a new bank named "Java S&L"
    String name = "Java S&L";
    Bank bank = new Bank(name);
    System.out.println("Bank Name:  Java S&L");
    
    //reads the accounts from the file specified by the command-line argument and prints a bank summary
    bank.loadAccountsFromFile(file);
    bank.printBankSunmmary();
    
    //accrues interest to all of the savings accounts, and substract the monthly fee from all checking acounts
    //print out the bank summary 
    System.out.println("");
    System.out.println("Bank Name:  Java S&L");
    bank.accrueInterestToSavingsAccounts();
    bank.applyFeesToCheckingAccounts();
    bank.printBankSunmmary();
  }
}


