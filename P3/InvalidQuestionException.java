/**this class is a subclass of Exception*/

public class InvalidQuestionException extends Exception{
  
  /**creates a constructor that sets the exception message*/
  public InvalidQuestionException(){
    super("Question not understood");
  }
}