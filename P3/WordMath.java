/*
 CSE 17 
 Zihan Liu 
 zil317
 Program #3 DEADLINE: November 8, 2016
 Program Description: Conversational Arithmetic 
 */


import java.util.Scanner;
import java.util.ArrayList;

/**this class allows user to perform arithmetic operations*/
public class WordMath{
  /**creates fields*/
  public static final int ADDITION = 0;
  public static final int SUBTRACTION = 1;
  public static final int MULTIPLICATION = 2;
  public static final int DIVISION = 3;
  
  /**Attemps to match question to one of the entries in templates*/
  public Expression parseQuestion(String question, ArrayList<QuestionTemplate> templates) throws InvalidQuestionException{
    
    for (int i=0; i< templates.size(); i++){
      if (templates.get(i).isMatch(question)){
        return templates.get(i).parseQuestion(question);
      } 
    }
    throw new InvalidQuestionException();
  }
  
  /**main method*/
  public static void main(String[] args){
    ArrayList <QuestionTemplate> myQuestion = new ArrayList <QuestionTemplate>();
    
    QuestionTemplate question1 = new QuestionTemplate("What is","plus","?",WordMath.ADDITION);
    QuestionTemplate question2 = new QuestionTemplate("Tell me the sum of","and","?",WordMath. ADDITION);
    QuestionTemplate question3 = new QuestionTemplate("What do I get if I add","and","together?", WordMath.ADDITION);
    QuestionTemplate question4 = new QuestionTemplate("What is","minus","?",WordMath.SUBTRACTION);
    QuestionTemplate question5 = new QuestionTemplate("","less","is what?",WordMath.SUBTRACTION);
    QuestionTemplate question6 = new QuestionTemplate("What is","times","?",WordMath.MULTIPLICATION);
    QuestionTemplate question7 = new QuestionTemplate("What do I get when I multiply","and","?",WordMath.MULTIPLICATION);
    QuestionTemplate question8 = new QuestionTemplate("What is","divided by","?",WordMath.DIVISION);
   
    myQuestion.add(question1);
    myQuestion.add(question2);
    myQuestion.add(question3);
    myQuestion.add(question4);
    myQuestion.add(question5);
    myQuestion.add(question6);
    myQuestion.add(question7);
    myQuestion.add(question8);
    
    System.out.println("Please enter a question");
    Scanner scan = new Scanner(System.in);
    String userQuestion  = scan.nextLine();
    
    WordMath a = new WordMath();
    //if the quetsion can be parsed, evaluates the expression and returns the answer in word form
    try{
      a.parseQuestion(userQuestion, myQuestion);
      System.out.println("The answer is "+a.parseQuestion(userQuestion, myQuestion).evaluateInWords());
    }catch(InvalidQuestionException ex){
      System.out.println("I'm sorry, I don't understand the question. Please rerun and repharse your question");
    }  
  }
}