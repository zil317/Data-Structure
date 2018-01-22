
import java.util.*;

/**The class converts a number from 0-99 to word and converts a word to its matched number*/
public class NumberConvertor{
  
  /**creates fields FIRST_NUMBERS, TENS_NUMBERS and Arraylist numberslist*/
  private String[] FIRST_NUMBERS = new String[] {"zero","one","two", "three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
  private String[] TENS_NUMBERS = new String [] {"twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
  private ArrayList<NumberWord> numbersList;
  
  /**initializes numbersList by creating the appropriate NumberWords objects and then sorts the list by the spelling of the words*/
  public NumberConvertor(){
    
    this.numbersList = new ArrayList<NumberWord>();
    
    for(int i=0; i<FIRST_NUMBERS.length;i++){
      numbersList.add(new NumberWord(i,FIRST_NUMBERS[i]));
    }
    
    for(int i=20; i<100;i+=10){
      numbersList.add(new NumberWord(i,TENS_NUMBERS[(i/10) - 2]));
    }
                                    
    Collections.sort(numbersList);
    
  }
  
  /**given a single number word, uses binary search to look it up and return the associated int value. If not found, return -1*/
  private int lookupValueOfWord(String numberWord){
    int low = 0;
    int high = numbersList.size() - 1;
    
   while(high>=low){
      int middle = (low +high)/2;
      if (numberWord.compareTo(numbersList.get(middle).getInWords()) == 0){
        return numbersList.get(middle).getValue();
      }
      if(numberWord.compareTo(numbersList.get(middle).getInWords())<0){
        low = middle+1;
      }
      if(numberWord.compareTo(numbersList.get(middle).getInWords())>0){
        high = middle-1;
      }
    }
    return -1;
    
  }
  
  /**Using the numbesList, converts the words for any number between 0 to 99 into the equivalent word(s)*/
  public int toNumber(String numberWords){
    
    if(numberWords.contains("-")){
      String s1 = numberWords.substring(0, numberWords.indexOf('-'));
      String s2 = numberWords.substring(numberWords.indexOf('-') + 1, numberWords.length());
  
      if(lookupValueOfWord(s1)==-1 || lookupValueOfWord(s2)==-1){
        return -1;
      }
      
      else{
        int Ten_Integer = lookupValueOfWord(s1);
        int First_Integer = lookupValueOfWord(s2);
        return Ten_Integer+First_Integer;
       
      }
    }
       else{
         if(lookupValueOfWord(numberWords)==-1){
           return -1;
         }
         else{
           return lookupValueOfWord(numberWords);
         }
       }
  }
  
  /**Converts a numeric value between 0 to 99 into the equivalent word(s)*/
  public String toWords(int value){
    
    if (value<99 && value>0){
      
      if(value <= 19){
        return FIRST_NUMBERS[value];
      }
      else{
        int tenNumber = value/10;
        int firstNumber = value%10;
        
        String s1 = TENS_NUMBERS[tenNumber-2];
        String s2 = FIRST_NUMBERS[firstNumber];
        
        if(s2.equals("zero")){
          return s1;
        }
        else{
          return s1+"-"+s2;
        }
      }   
    }
    
    else{
      return "Not a number that I can put into words "+value;
    }
  }
}
      
    
        
    
    
    
    
    
 
  
  
      
      
      
    
    