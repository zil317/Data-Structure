import java.util.ArrayList;
import java.io.File;

public class Dictionary{
  
  private int maxWordLength;
  private ArrayList<String>[] dictionaryList;
 
  
  public Dictionary(int maxWordLength){
    dictionaryList = (ArrayList<String>[])new ArrayList[maxWordLength];
    for(int i=0; i< maxWordLength; i++){
      dictionaryList[i] = new ArrayList<String>();
    }
  }
  
  public Dictionary(){
    this(10);  
  }
  
  public void addEntry(String word){
        dictionaryList[word.length()-1].add(word);
  }
  
  public boolean lookup(ArrayList<String> wordList, String s, int low, int high){
    
    if(low > high){
      return false;
    }
    
    int mid = (low + high) /2;
      
    if(s.compareTo(wordList.get(mid)) < 0){
        return lookup(wordList, s, low, mid-1);
      }
      else if (s.compareTo(wordList.get(mid)) == 0){
        return true;
      }
      else{
        return lookup(wordList, s, mid+1, high);
      }
    
  }
    
  public boolean lookup(String s){
    ArrayList<String> wordList = dictionaryList[s.length()-1]; 
    return lookup(wordList, s, 0, wordList.size()-1);
  }
  
  
}
  
  
  
    