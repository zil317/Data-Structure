
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Jumble{
  
  
  public String[] findPermutation (String s){
    ArrayList<String> permutations = new ArrayList<String>();
 
    findPermutation(s, "", permutations);
    
    String [] array = new String[permutations.size()]; 
    
    for (int i =0; i< array.length; i++){
      array[i]  = permutations.get(i);
    }
    return array;
  }
  
  private void findPermutation(String s1, String s2, ArrayList<String> permutations){
    
    if(s1.length() == 0 && !permutations.contains(s2)){
      permutations.add(s2); 
    }
    
    else{
      for( int i=0; i<s1.length(); i++){
        
        String newS2 = s2 + s1.charAt(i);
        String newS1 = s1.substring(0,i) + s1.substring(i+1, s1.length());
      
        findPermutation(newS1, newS2, permutations);
      }
    }
    
  }
  
  
  public static void main(String[] args){
    
    int i = 0;
    Dictionary newD = null;
    String filename = "";
    Scanner scan = new Scanner(System.in);
    
    if(args.length <1 || args.length >2){
      System.out.println("Usage:java Document filename");
      System.exit(1);
    }
     else if (args.length == 1) {
       filename = args[0];
       newD = new Dictionary();
    }
    
      else if (args.length == 2) {
      int maxWordLength = Integer.parseInt(args[0]);
      filename = args[1];
      newD = new Dictionary(maxWordLength);
    }
    
      File file = new File(filename);
      try
      {
      scan = new Scanner(file);
      }catch(FileNotFoundException exception){
        System.out.println("File is not found");
      }
        
     
      while(scan.hasNextLine()){
        String word = scan.next();
        i++;
        newD.addEntry(word);
      }
      scan.close();
      
      System.out.println("Read in "+i+" words");
      
      Jumble jumble = new Jumble();
      
      System.out.println("Enter a scambled word:");
      scan = new Scanner(System.in);
      String inputWord = scan.next();
      String[] scrambledArray = jumble.findPermutation (inputWord);
      
      boolean valueNotFound = true;
      
      
      for(int j=0; j< scrambledArray.length; j++){
        if (newD.lookup (scrambledArray[j]) == true ){
          System.out.println(scrambledArray[j]);
        }
        else{
          valueNotFound = false;
        }
      }
      
      if(valueNotFound = false){
        System.out.println("No words are formed from "+inputWord);
      }
        
  }
  
  
  
  
}
  
    