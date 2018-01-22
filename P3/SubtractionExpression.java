


/**This class performs substraction*/
public class SubtractionExpression extends Expression{
  
  /**contructor*/
  public SubtractionExpression(String leftOp, String rightOp) throws InvalidQuestionException{
    super(leftOp,rightOp);
  }
  
  /**performs substraction*/
  public int evaluate(){
    return leftOpInt-rightOpInt;
  }
}