/*
 CSE 17
 Zihan Liu
 zil317
 Homework #4    DEADLINE: Oct. 25, 2016
 Program: CSE Department Personnel
 */

/**This class creates an employee profile*/
public class Employee{
  
  /**create String name, String title, String email*/
  protected String name;
  protected String title;
  protected String email;
  
  /**create the constructor. Initializes the fields using parameter values*/
  public Employee(String name, String title, String email){
    this.name = name;
    this.title = title;
    this.email = email;
  }
  
  /**get method for name*/
  public String getName(){
    return name;
  }
  
  /**get method fro title*/
  public String getTitle(){
    return title;
  }
  
  /**get method for email*/
  public String getEmail(){
    return email;
  }
  
  /**overides Objects' toString method. Returns a string of the form "name(email), Staff, title"*/
  public String toString(){
    return this.name +" ("+this.email+"), Staff, "+this.title;
  }
  
  /**overrides Object's equals method. Two employees are considered equal if they have the same email address*/
  public boolean equals(Object o){
    if (o instanceof Employee){
     Employee employee =  (Employee)o;
      return email.equals(employee.email); 
    }
     else{
       return false;
     }
  }
 
}
  
    
    
    
    
    
    
    
    
    
    
    
    