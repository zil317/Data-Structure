


/**This class performs multiplication*/
public class MultiplicationExpression extends Expression{
  
  /**constructor*/
  public MultiplicationExpression(String leftOp, String rightOp) throws InvalidQuestionException{
    super(leftOp, rightOp);
  }
  
  /**performs multiplicatoin operation*/
  public int evaluate(){
    return leftOpInt*rightOpInt;
  }
}