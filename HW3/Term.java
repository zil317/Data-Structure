/*
 CSE 17 
 Zihan Liu 
 zil317 
 DEALLINE: September 30, 2016
 Program Description: This program is used to analyze a short passage of text, and exercise how to work with strings and command-line arguments
 */


public class Term {
  
  /*create private string field token and integer field frequency*/
  private String token;
  private int frequency;
  
  /*a constructor that takes two formal parameters: a token string and a frequency*/
  public Term(String token, int frequency){
    this.token = token;
    this.frequency = frequency;
  }
  
  /*a constructor that takes a token string parameter and creates a term with frequency of 1*/
  public Term(String token){
    frequency=1;
  }
   /*get method for token*/
  public String getToken() {
    return token;
  }
  
  /*get method for frequency*/
  public int getFrequency(){
    return frequency;
  }
  
  /*a constructor that takes an integer value and adds that value to the current frequency of the Term*/
  public void addToFrequency(int integer){
    frequency = getFrequency()+integer;
  }
  
  /*takes a single char formal parameter and returns the total number of times that character appears with the term*/
  public int getLetterCount(char parameter){
    int count=0;
    for(int i=0; i<token.length(); i++){
      if(token.charAt(i) == parameter){
        count++;
      }
    }
    return count;
  }
}
    
    
        
    
                          
                          
                          
                          
                          
                          