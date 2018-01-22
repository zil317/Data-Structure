
/**This class creates numberWord and implements Comparable interface*/
public class NumberWord implements Comparable{
  
  /**creates fields value and inWords*/
  private int value;
  private String inWords;
  
  /**Initializes the fields*/
  public NumberWord(int value, String inWords){
    this.value = value;
    this.inWords = inWords;
  }
  
  /**The get method for value*/
  public int getValue(){
    return value;
  }
  
  /**The get method for inWords*/
  public String getInWords(){
    return inWords;
  }
  
  /**compares the current number to obj, using inWords*/
  public int compareTo(Object obj){
    return ((NumberWord)obj).getInWords().compareTo(this.getInWords());
  }
}