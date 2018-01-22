
/**The class is an abstract class that performs arthmetic operations*/
public abstract class Expression{
  
  /**creates fields leftOpInt, rightOpInt and numConvertor*/
  protected int leftOpInt;
  protected int rightOpInt;
  public NumberConvertor numConvertor = new NumberConvertor();
  
  
  /**Initialize the leftOpInt ad the rightOpInt using strings that express their values in words. If either operand cannot be interpreted, throws an exception*/
  public Expression (String leftOp, String rightOp) throws InvalidQuestionException {
    
    this.leftOpInt = numConvertor.toNumber(leftOp);
    this.rightOpInt = numConvertor.toNumber(rightOp);
    
    if(leftOpInt==-1 || rightOpInt==-1){
      throw new InvalidQuestionException();
    }
  }
  
  /**perform the arthmetic operation using the left and right operands and return the result*/
  public abstract int evaluate();
  
  /**perform the arithemetic operation and return the numeric result expressed as words*/
  public String evaluateInWords(){
    return numConvertor.toWords(evaluate());
  }
}
  
  
  