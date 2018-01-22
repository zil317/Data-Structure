/*
 CSE 17
 Zihan Liu
 zil317
 Homework #4    DEADLINE: Oct. 25, 2016
 Program: CSE Department Personnel
 */

/**This class signals that there was an attempt to add an employee with the same email as an existing one.
  * and it extends ArrayStoreException*/
public class DuplicateEmployeeException extends ArrayStoreException{
  
  /**create String email that was duplicated*/
  private String email;
  
  /**set the exception messsage to "Duplicate employee: email"*/
  public DuplicateEmployeeException(String email){
    super("Duplicate employee: "+ email);
  }
  
  /**get method for email*/
  public String getEmail(){
    return email;
  }
}
  
  