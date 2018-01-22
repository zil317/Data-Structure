

/**This class represents a set of cards held by a player*/
public class Hand{
  
  /**create a linked list of cards in hand*/
  private MyLinkedList<Card> cards;
  
  /**create a constructor that creates an empty hand*/
  public Hand(){
    cards = new MyLinkedList<Card>();
  }
  /**add the card c to the hand*/
  public void addCard(Card c){
    cards.add(cards.size(),c);
    //cards.size++;
  }
  
  /**remove the card c from the hand. Does nothing if the card is not in the hand*/
  public void removeCard(Card c){
    cards.remove(c);
  }
  
  /**return true if the hand contains the card c*/
  public boolean contains(Card c){
    return cards.contains(c);
  }
  
  /**returns the card at the specified index. returns null if the index is invalid*/
  public Card getCard(int index){
    if(index<0 || index>cards.size){
      return null;
    }
    return cards.get(index);
  }
  
  /**return the number of cards in the hand*/
  public int size(){
    return cards.size();
  }
  
  /**return a descrption of cards of the hand*/
  public String toString(){
    for(int i=0; i<cards.size(); i++){
     return cards.get(i).toString();
    }
    return "";
  }
}
  
  
  