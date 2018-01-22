
import java.util.*;
import java.io.*;

/**This class is to create a Linkedlist*/
public class MyLinkedList<E> extends MyAbstractList<E>{
  
  /**create variable head and tail*/
  private Node<E> head;
  private Node<E> tail;
  
  /**constructor */
  public MyLinkedList(){
  }
  
  /**constructor */
  public MyLinkedList(E[] objects){
    super(objects);
  }
   /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<E>(e); 
    newNode.next = head; 
    head = newNode; 
    size++; 

    if (tail == null)
      tail = head;
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<E>(e); 

    if (tail == null) {
      head = tail = newNode; 
    }
    else {
      tail.next = newNode; 
      tail = tail.next; 
    }

    size++; 
  }
  
  
  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }
    else {
      Node<E> temp = head;
      head = head.next;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp.element;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      return null;
    }
    else if (size == 1) {
      Node<E> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else {
      Node<E> current = head;

      for (int i = 0; i < size - 2; i++) {
        current = current.next;
      }

      Node<E> temp = tail;
      tail = current;
      tail.next = null;
      size--;
      return temp.element;
    }
  }
  
/**return true if the list contains the element e*/
  public boolean contains (E e) {
    Node<E> current = head;
    for (int i =0; i < size; i++) {
      if (current.element.equals(e)) return true;
      current = current.next;
    }
    return false;
    
  }
  
  /**return the element from this list at the specified index. return null if the index of invalid*/
  public E get(int index){
    Node<E> node = head;
    if(index >= size || index < 0){
      return null;
    }
    
    if (index <size && index >= 0){
      for(int i=0; i<index; i++){
        node = node.next;
      }
    }
    return node.element;
  }
        
  /**return the index of the first matching element in this list. Return -1 if no match is found. The index starts at 0*/
  public int indexOf (E e){
    Node<E> current = head;
    for (int i=0; i<size; i++) {
      if (current.element.equals(e)) {
        return i;
      }
      current = current.next;
    }
    return -1;
    
  }
  
  /**Remove the list of elements from start index to end index from the list, and returns a new linked list consisting of just these elements.
    * if start > end or either index out of bounds, then return null.*/
  public MyLinkedList <E> extractSublist(int start, int end){
    if(start < 0|| start > this.size()-1||end < 0 || end >this.size()-1){
      throw new IndexOutOfBoundsException("Index out of bound");
    }
    if(start > end){
      return null;
    }
    MyLinkedList<E> list = new MyLinkedList<E>();
    
    for (int i = start; i<=end; i++){
      list.add(start, get(start));
      remove(start);
     // size--;
    }
    //list.size = end+1-start;
    return list;
    
  }
  
  /**adds the list prefix to the front of the existing list. Updates all relevent fileds for consistency*/
  public void prepend (MyLinkedList<E> prefix){
    prefix.tail.next = this.head;
    this.head = prefix.head; 
    if(size == 0){
      this.tail = prefix.tail;
    }
    size=prefix.size+this.size;
  }
  
  /**Add a new element at the specified index in this list. The index of the head element is 0*/
  public void add(int index, E e){
    if (index == 0){
      addFirst(e);
    }
    else if (index >= size){
      addLast(e);
    }
    else{
      Node<E>current = head;
      for (int i=1; i< index; i++){
        current = current.next;
      }
      Node<E> temp = current.next;
      current.next = new Node<E>(e);
      (current.next).next = temp;
      size++;
    } 
  }
  
  /**remove the element at the specified position in this list. Return the element that was removed from the list*/
  public E remove(int index){
     if (index < 0 || index >= size) {
      return null;
    }
    else if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = head;

      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }

      Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }
 
  

  /** Replace the element at the specified position in this list
   *  with the specified element. */
  public Object set(int index, E e){
    return null;
  }

  /**clear method*/
  public void clear(){
  }
  
 
  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }
  
  /**Node class*/
   private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
    }
  }
   
}
  
  