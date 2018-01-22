
/**This class performs addition operation*/
public class AdditionExpression extends Expression{
  
  /**constructor*/
  public AdditionExpression(String leftOp, String rightOp) throws InvalidQuestionException{
      super(leftOp, rightOp);
  }
  
  /**perform addition*/
  public int evaluate(){
    return leftOpInt+rightOpInt;
  }
}