/*
 CSE 17 
 Zihan Liu 
 zil317
 Homework #5  DEADLINE:November 30, 2016 
 Program: Quick sort comparison 
 */

/*
Size        Quick sort(default)         Quick Sort(smart pivot)
100000          138                           152
250000           69                           115
500000          161                           231
750000          271                           281
1000000         417                           415

The smart pivot version is better than the original quick sort.
The fix pivot and the smart pivot work the same way in the many cases. 
However, smart pivot could help avoid the worst case run time O(n^2). 
In the default case, the first element is always the pivot
and if the array is original sorted or reversely sorted, all elements will go to only one partition.
The smart pivot could help minimize the chance that you will encounter worst cases. 
*/



import java.util.*;


public class GenericQuickSort{
  
  /**a generic implementation of quick sort. If smartPivot is false, then the pivot is always the first element in the list. 
    * otherwise, the algorithm chooses the pivot to be the medium value among the first, middle and last elementss of the list*/
  public static <E extends Comparable<E>> void quickSort (E[] list, boolean smartPivot){

   quickSort(list, 0 , list.length-1, smartPivot);
    
  }
  
  /**The recursive helper method for quick sort*/
  private static <E extends Comparable<E>> void quickSort (E[] list, int first, int last, boolean smartPivot){
   // System.out.println("first" +first);
    //  System.out.println("last" +last);
    
    if(last > first){
      
        int pivotIndex = partition(list, first, last, smartPivot);
        quickSort(list, first, pivotIndex - 1, smartPivot);
        quickSort(list, pivotIndex + 1, last, smartPivot);
    }
      
  }
  
  /**Choose a pivot and partition the list into two sets: the elements less than the pivot and the elements greater than the pivot.
    * place the pivot between these two sets and return its index.
    if smartPivot is false, then the pivot is always the first element in the list.
    otherwise, the algorithm chooses */
  private static <E extends Comparable<E>> int partition (E[] list, int first, int last, boolean smartPivot){
    E pivot;
    int low = 0;
    int high = 0;
    
    if(!smartPivot){
      pivot = list[first];
      low = first+1;
      high = last;
    }
    else{
      
      //choose the pivot to be the medium value among the first, middle and last elements of the list.
      int middle = (last-first)/2;
      E temp =list[first];
      
      if(list[first].compareTo(list[middle]) < 0 && list[middle].compareTo(list[last]) < 0||
      list[last].compareTo(list[middle]) < 0 && list[middle].compareTo(list[first]) < 0){
        list[first] = list[middle];
        list[middle] = temp;
        
      }
      
      else if(list[middle].compareTo(list[last]) < 0 && list[first].compareTo(list[last])<0||
      list[last].compareTo(list[middle])<0 && list[last].compareTo(list[first]) < 0){
        list[first] = list[last];
        list[last]= temp;
      }
 
        pivot = list[first];
        low = first+1;
        high = last;
       
    }
   
    
    
    while (high > low){
      
      while (low <= high && pivot.compareTo(list[low]) >= 0 ){
        low++;
      }
      while(low <= high && pivot.compareTo(list[high]) < 0){
        high--;
      }
      
      if (high > low){
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }
    
    while (high > first && list[high].compareTo(pivot) >=0 ){
      high--;
    }
      
      if(pivot.compareTo(list[high])>0){
        list[first] = list[high];
        list[high] = pivot;
        return high;
      }
      else{
        return first;
      }
    }
    
  /**returns an array containing size random integers between 0 and 999,999 inclusive*/ 
  public static Integer[] makeRandomIntList (int size){
    Integer[] intArray = new Integer[size];
    
    Random randomNumber = new Random();
    
    for (int i= 0; i<size; i++){
      intArray[i] = randomNumber.nextInt(999999);
    }
    return intArray;
  }
  
  /**main method*/
  public static void main(String[] args){
    
    System.out.println("Comparing sorts on lists of integers: ");  
    System.out.println("Size        Quick sort(default)         Quick Sort(smart pivot)");

   //create an array of 100,000
   Integer[] list1 = makeRandomIntList(100000);
   Integer[] listcopy1 = new Integer[list1.length];
   System.arraycopy(list1, 0, listcopy1, 0, 100000);
 
    long startList1 = System.currentTimeMillis();
    quickSort(list1, false); 

    long endList1 = System.currentTimeMillis();
    long timeList1 = endList1 - startList1;
    
    //smart pivot condition 
    long startListCopy1 = System.currentTimeMillis();
    quickSort(listcopy1, true); 

    long endListCopy1 = System.currentTimeMillis();
    long timeListcopy1 = endListCopy1 - startListCopy1;
    
    System.out.format(100000+"\t\t" + timeList1+"\t\t" + timeListcopy1);
    System.out.println("");
    
    //create an array of 250,000
    Integer[] list2 = makeRandomIntList(250000);
   Integer[] listcopy2 = new Integer[list2.length];
   System.arraycopy(list2, 0, listcopy2, 0, 250000);
 
    long startList2 = System.currentTimeMillis();
    quickSort(list2, false); 

    long endList2 = System.currentTimeMillis();
    long timeList2 = endList2 - startList2;
    
    //smart pivot condition 
    long startListCopy2 = System.currentTimeMillis();
    quickSort(listcopy2, true); 

    long endListCopy2 = System.currentTimeMillis();
    long timeListcopy2 = endListCopy2 - startListCopy2;
    
    System.out.format(250000+"\t\t" + timeList2+"\t\t" + timeListcopy2);
    System.out.println("");
    
    //create an array of 500,000
    Integer[] list3 = makeRandomIntList(500000);
   Integer[] listcopy3 = new Integer[list3.length];
   System.arraycopy(list3, 0, listcopy3, 0, 500000);
 
    long startList3 = System.currentTimeMillis();
    quickSort(list3, false); 

    long endList3 = System.currentTimeMillis();
    long timeList3 = endList3 - startList3;
    
    //smart pivot condition 
    long startListCopy3 = System.currentTimeMillis();
    quickSort(listcopy3, true); 

    long endListCopy3 = System.currentTimeMillis();
    long timeListcopy3 = endListCopy3 - startListCopy3;
    
    System.out.format(500000+"\t\t" + timeList3+"\t\t" + timeListcopy3);
    System.out.println("");
    
    
    //create an array of 750,000
    Integer[] list4 = makeRandomIntList(750000);
   Integer[] listcopy4 = new Integer[list4.length];
   System.arraycopy(list4, 0, listcopy4, 0, 750000);
 
    long startList4 = System.currentTimeMillis();
    quickSort(list4, false); 

    long endList4 = System.currentTimeMillis();
    long timeList4 = endList4 - startList4;
    
    //smart pivot condition 
    long startListCopy4 = System.currentTimeMillis();
    quickSort(listcopy4, true); 

    long endListCopy4 = System.currentTimeMillis();
    long timeListcopy4 = endListCopy4 - startListCopy4;
    
    System.out.format(750000+"\t\t" + timeList4+"\t\t" + timeListcopy4);
    System.out.println("");
    
    //create an array of 1,000,000
    Integer[] list5 = makeRandomIntList(1000000);
   Integer[] listcopy5 = new Integer[list5.length];
   System.arraycopy(list5, 0, listcopy5, 0, 1000000);
 
    long startList5 = System.currentTimeMillis();
    quickSort(list5, false); 

    long endList5 = System.currentTimeMillis();
    long timeList5 = endList5 - startList5;
    
    //smart pivot condition 
    long startListCopy5 = System.currentTimeMillis();
    quickSort(listcopy5, true); 

    long endListCopy5 = System.currentTimeMillis();
    long timeListcopy5 = endListCopy5 - startListCopy5;
    
    System.out.format(1000000+"\t\t" + timeList5+"\t\t" + timeListcopy5);
    System.out.println("");
    
  
  }
  
  
}
  
  
  
  
  
  
  
  
  