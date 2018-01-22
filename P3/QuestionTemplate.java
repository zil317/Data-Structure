
/**This class interprets questions*/
public class QuestionTemplate{
  /**creates field preText, middleText, endText and operation*/
  private String preText;
  private String middleText;
  private String endText;
  private int operation;
  
  /**Initialize the fields*/
  public QuestionTemplate(String preText, String middleText, String endText, int operation){
    this.preText = preText;
    this.middleText = middleText;
    this.endText = endText;
    this.operation = operation;
  }
  
  /**return true if question matches the template*/
  public boolean isMatch(String question){
    return question.startsWith(preText) && question.endsWith(endText) && question.contains(middleText);
  }
  
  /**given a question, returns the equivalent subtype of Expression*/
  public Expression parseQuestion(String question) throws InvalidQuestionException{
    int indexOfPreText = question.indexOf(preText);
    int indexOfMiddleText = question.indexOf(middleText);
    int indexOfEndText = question.indexOf(endText);
    String leftOp = question.substring(indexOfPreText+preText.length(), indexOfMiddleText-1).trim().toLowerCase();
    String rightOp = question.substring(indexOfMiddleText+middleText.length(),indexOfEndText).trim().toLowerCase();
   
    
      if(operation == WordMath.ADDITION){
        return new AdditionExpression(leftOp, rightOp);
      }
      else if(operation == WordMath.SUBTRACTION){
        return new SubtractionExpression(leftOp, rightOp);
      }
      else if(operation == WordMath.MULTIPLICATION){
        return new MultiplicationExpression(leftOp, rightOp);
      }
      else if(operation == WordMath.DIVISION){
        return new DivisionExpression(leftOp, rightOp);
      }
        
    
    else{
      throw new InvalidQuestionException();
    }
  }
  
  
  
}