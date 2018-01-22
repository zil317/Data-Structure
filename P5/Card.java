
import java.util.*;

/**this class is to create an immutable representation of a standard of playing card*/
public class Card{
  
  /**create suit and rank fields*/
  private char suit; //indicated by letter
  private int rank; //integer
  
  /**A constructor that creats a card with the specified rank that suit. 
    * Throws a java.lang.IllegalArgumentException is the value of the suit or rank is not in the expected range*/
  public Card (char suit, int rank) throws IllegalArgumentException{
 
   if( suit!='C' || suit!='D'|| suit!='H' || suit!='S' || rank < 1 || rank > 13){
      throw new IllegalArgumentException("The value of the suit or rank is not the expected range.");
   } 
   
   this.suit = suit;
   this.rank = rank;
  }
  
  /**return the suit of the card*/
  public char getSuit(){
    return suit;
  }
  
  /**return the rank of the card*/
  public int getRank(){
    return rank;
  }
  
  /**return a short but meaningful description of the card*/
  public String toString(){
    if(rank == 1){
      return "A"+suit;
    }
    else if(rank == 11){
      return "J" +suit;
    }
    else if(rank == 12){
      return "Q"+suit;
    }
    else if(rank == 13){
      return "K"+suit;
    }
    else{
      return Integer.toString(rank) + suit;
    }
      
  }
  
  /**return true if o has the same suit and rank as this card*/
  public boolean equals(Object o){
    if(o instanceof Card){
      if( rank == ((Card)o).getRank() && suit== ((Card)o).suit){
       return true;
     }
   }
    return false;
  }
}

  
  
  
  
    
    
  