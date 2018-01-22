
import java.util.*;

/**this class represents a standard deck of 52 playing cards: it contains four suits, each with one card of each rank*/
public class Deck{
  /**create linked list of cards in the deck. The top of the deck is the head in the list*/
  private MyLinkedList<Card> cards;
  
  /**A constructor that creates a deck with the cards ordered first by suit and then by rank.*/
  public Deck(){
    char[] suits = {'C' ,'D', 'H', 'S'};
    cards = new MyLinkedList<Card>();
    
    int count = 1;
    for( int i = 0; i< suits.length; i++){
      for(int j=1; j< 14; j++){
        Card card = new Card(suits[i],j);
        cards.add(count, card);
        count++;
      }
    }
  }
  
  /**Shuffle the deck
    * randomly pick a start and end index for a sublist,
    remove this sublist from the list using extractSublist, and then put it at the beginning of the deck using prepend.
    Any length of sublist between 1 and 51, inclusive, as long as the start index is less than the end.
    repeat for 30 times*/
  public void shuffle(){
    Random random = new Random ();

    for(int i=0; i<30; i++){
      int startIndex = random.nextInt(cards.size());
      int endIndex = random.nextInt(cards.size() - startIndex) + startIndex;
      if(startIndex == endIndex){
        i--;
        continue;
        
      }
     // System.out.println("START is "+startIndex+"   END is " +endIndex);
      MyLinkedList<Card> subList = cards.extractSublist(startIndex, endIndex);
      
      cards.prepend(subList);
     // System.out.println(cards.size());
    } 
  }
  
  /**remove the first card from the deck and returns it. returns null if the deck is empty*/
  public Card draw(){
    if(cards.size>=1){
      return cards.remove(0);
  }
    else{
      return null;
    }
  }
  
  /**remove the card c from hand h, places at the bottom fo the Deck, and adds the first card from the deck to the hand
    * if the card argument is not in hand, or the deck is empty then nothing happens*/
  public void exchangeCard(Hand h, Card c){
    if(h.contains(c) == true && cards!= null){
      h.removeCard(c);
      cards.add(51,c);
      h.addCard(cards.get(0));
      cards.remove(0); 
    }     
  }
  
  /**Deal out a total of numHands*handsize cards to the specified number of hand.
    * if there are insurfficient cards to complete the deal, then it returns the cards ater the last card is dealt*/
  public Hand[] deal(int numHands, int handSize){
    Hand[] hand = new Hand[numHands];
    int i=0;
    for(int k=0; k<numHands; k++){
      hand[k]= new Hand();
    }
    

    for(int j=0; j< handSize; j++){
      for(i=0; i<numHands; i++){
        if(cards.size()>=1){
          hand[i].addCard(cards.get(0));
          cards.remove(0);  
        }
      }
      
    }
    return hand;

  }
  /**Return a string listing the contents of the deck in order*/
  public String toString(){
    System.out.print("[");
    String str = "";
    for(int i= 0; i<cards.size(); i++){
      if(i ==cards.size()-1){
        System.out.print( cards.get(i).toString() +"]");
      }
      else{
        System.out.print(cards.get(i).toString()+", ");
      }
    }
   return "";
  }
      
    
  
 /**main method*/ 
 public static void main(String[] args) {

   Deck myDeck = new Deck();
   System.out.println("Initial Deck:");
   System.out.println(myDeck.toString());
   myDeck.shuffle();
   System.out.println("Deck after shuffle:");
   System.out.println(myDeck.toString());
   System.out.println("Dealing...");
   Hand[] myHands = myDeck.deal(4,5);
   for (int i=0; i < myHands.length; i++)
     System.out.println("Hand " + i + ": " + myHands[i]);
   System.out.println("Deck after deal:");
   System.out.println(myDeck.toString());
   System.out.println("Hand 0 exchanging first card:");
   myDeck.exchangeCard(myHands[0], myHands[0].getCard(0));
   System.out.println("New Hand 0: " + myHands[0]);
   System.out.println("Deck after exchange:");
   System.out.println(myDeck.toString());
 }
}