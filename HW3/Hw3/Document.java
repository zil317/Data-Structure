/*
 CSE 17 
 Zihan Liu 
 zil317 
 DEALLINE: September 30, 2016
 Program Description: This program is used to analyze a short passage of text, and exercise how to work with strings and command-line arguments
 */

import java.util.Scanner;
import java.io.File;

/*create private int field for numTerms and private Term array field for terms*/
public class Document {
  private int numTerms;
  private Term[] terms;
  
  /*a constructor that initializes terms to be able to hold up to 50 terms and sets numTokens to 0*/
  public Document() {
    int numTerms=0;
    terms= new Term[50];
  }
  /*takes a string parameter and updates the terms array to count the token*/
  public void addToken (String parameter) {
    
    if(numTerms == terms.length){
        return;
      }
    boolean flag = false;
    for(int i=0; i<terms.length; i++){
        if (terms[i]!=null && parameter.equals(terms[i].getToken()) ) {
           terms[i].addToFrequency(1);
           flag = true;
         }
    }
       
    if(!flag){
      //System.out.println(parameter);
           Term newterm = new Term(parameter, 1);
           terms[numTerms]=newterm;
           numTerms++;
         } 
  }
  
  
  /*takes a strong token and return the index of the term with the same token in the terms array. If there is no match return -1*/
  private int findIndexOfTerm (String token) {
    for (int i=0; i<numTerms; i++) {
      if (token.equals(terms[i].getToken()) ){
        return i;
      }
      else{
        return -1;
      }
    }
    return 0;
  }
    
  
  
  /*prints a table of terms and their frequencies*/
  public void printTermFreqs() {
    System.out.println("Term        Frequency");
    System.out.println("-----       -----------");
    for (int i=0; i<numTerms; i++) {
      System.out.printf("%-10.20s  %-4d\n", terms[i].getToken(), terms[i].getFrequency());
    }
  }
  
  /*accepts a char formal parameter that specifies a letter, and returns the total number of times that letter appears in the documents*/
  public int getLetterCount(char letter) {
    int times=0;
    for (int i=0; i< numTerms; i++){
      times+= terms[i].getLetterCount(letter)*terms[i].getFrequency();
    }
    return times;
  }
  
  
  
  /*A main method check that exactly one command-line argument has been given
   *create a document
   *print the term-frequency list 
   *ask for user input a char
   *finds out how many times the character appears in the documents 
   *print out results
   */
  public static void main (String[] args) throws Exception{
    
    java.io.File file = new java.io.File("howmuch.txt");
      
    if(args.length != 1){
      System.out.println("Usage:java Document filename");
      //System.exit(0);
    }
    
    Document document = new Document();
    
    Scanner fileScanner = new Scanner(file);
    
    while (fileScanner.hasNext()) {
       String input = fileScanner.next();  
       document.addToken(input);
    }
    
    document.printTermFreqs();
    fileScanner.close();
   
    System.out.println("Enter a letter and I'll count its occurences");
    Scanner scan = new Scanner (System.in);
    String x = scan.next();
    if(x.length()!=1){
      System.out.println("That is not a single character!");
  }
    document.getLetterCount(x.charAt(0));
    int occurences = document.getLetterCount(x.charAt(0));
    System.out.println("The letter "+ x.charAt(0) + " appears "+ occurences + " times");
    
  }
  
  
}
  
    
    
                
        
        
    