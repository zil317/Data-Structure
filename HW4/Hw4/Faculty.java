/*
 CSE 17
 Zihan Liu
 zil317
 Homework #4    DEADLINE: Oct. 25, 2016
 Program: CSE Department Personnel
 */

/**This class is a subclass of the Employee class and creates a faculty profile*/
public class Faculty extends Employee{
  
  /**create String research*/
  private String research;
  
  /**create the constructor. Initializes the fields using the parameter values*/
  public Faculty(String name, String title, String email, String research){
    super(name,title,email);
    this.research = research;
  }
  
  /**get method for research*/
  public String getResearch(){
    return research;
  }
  
  /**overrides Object's toString method. Returns a string of the form "name(email), Faculty, title" 
    * followed by the research topic on a separate line and indented by a tab*/
  public String toString(){
    return this.name +" ("+this.email+"), Faculty, "+this.title + "\n"+"\t"+this.research;
  }
}
