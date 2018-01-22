/*
 CSE 17
 Zihan Liu
 zil317
 Homework #4    DEADLINE: Oct. 25, 2016
 Program: CSE Department Personnel
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**This class creates a department profile that contains employees' information*/
public class Department{
  
  /**create java.util.ArrayList people*/
  private java.util.ArrayList people;
  
  /**create a constructor. Initializes people to be empty*/
  public Department(){
    people = new ArrayList();
  }
  
  /**adds the employee to the end of the people ArrayList. If there is an equivalent person in the list 
    * then instead of adding, it throws a DuplicateEmployeeException*/
  public void addPerson(Employee emp){
    
    if(people.contains(emp)){
      throw new DuplicateEmployeeException(emp.getEmail());
    }    
    else people.add(emp);
   }
    
    /**prints the employees to standard output using their toString methods.*/
    public void printPeople(){
      for(int i=0; i<people.size();i++){
        System.out.println(people.get(i).toString());
      }
    }
 
    
 public static void main (String[] args) {
   //if the Department class is run with anything other than a single command-line argument, then the program prints a message
   if(args.length != 1){
      System.out.println("Usage:java Department filename");
      System.exit(1);
    }
   
   File file = new File(args[0]);
   
   System.out.println("Reading people from file...");
   //create a department object 
   Department department = new Department();
   Scanner scan = null;
   
   //handle FileNotFoundException 
   try{
     scan = new Scanner(file).useDelimiter("\\t|[\\n\\r\\f]+");
   } catch (FileNotFoundException ex1) {
     System.out.println("ERROR: Couldn't read from file" + args[0]);
   }
   
   //reading from file
   while (scan.hasNext()) {
      String x = scan.next();
      Employee newEmployee = null;
      if (x.equals("S")){
       String a = scan.next();
       String b = scan.next();
       String c = scan.next();
       //if the line starts with S, store information and create a new Employee object  
       newEmployee = new Employee(a,b,c);
       
       //if a DuplicateEmployeeException is hown, it catches and throws a message
       try{
        department.addPerson(newEmployee);
      } catch (DuplicateEmployeeException ex2){
        System.out.println("Skipping duplicate for email");
      } 
      }
      else if (x.equals("F")){
        String a = scan.next();
        String b = scan.next();
        String c = scan.next();
        String d = scan.next();
        //if the line starts with F, store information and create a new Faculty object 
        newEmployee = new Faculty(a,b,c,d);
        try{
        department.addPerson(newEmployee);
      } catch (DuplicateEmployeeException ex2){
        System.out.println("Skipping duplicate for "+newEmployee.getEmail());
      } 
      }
      
      //if any line starts with something other than "S" or "F", the program should give a message and skip the line
      else{
        String a = scan.next();
        scan.next();
        scan.next();
        System.out.println("Skipping "+a+ ". Wrong type:" +x);
      }
      
   }
   scan.close();
   System.out.println("");
   System.out.println("CSE People: ("+ department.people.size() +" total)");
   //output the employees using the printPeople method
   department.printPeople();
 }
}

   
      
        
   
   
   
   
   
   
   
     
    