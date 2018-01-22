

/**This class performs division operation*/
public class DivisionExpression extends Expression{
  
  /**constructor*/
  public DivisionExpression(String leftOp, String rightOp) throws InvalidQuestionException{
    super(leftOp,rightOp);
  }
  
  /**performs division operation*/
  public int evaluate(){
    return leftOpInt/rightOpInt;
  }
}