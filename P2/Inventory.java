import java.io.File;            // if missing then must always say java.io.File below
import java.util.Scanner;       // if missing then must always say java.util.Scanner below

public class Inventory {

  public static void main(String[] args) throws Exception {
    Guitar[] stock = new Guitar[100];   // since we know it will be less than 100, use that to size array
    int count = 0;
    File file = new File(args[0]);
    Scanner in = new Scanner(file);
    while (in.hasNext()) {
      int itemNo = in.nextInt();
      String manufacturer = in.next();
      String style = in.next();
      int qty = in.nextInt();
      stock[count] = new Guitar(manufacturer, style, itemNo, qty);
      count++;
    }
    in.close();       // should ideally be there, but optional for this assignment
  }
}

/* This Guitar class is assumed as given for the test question. Thus, you did not need to
 * provide it as part of  your answer. I show it here so that the program will compile. */
class Guitar {
  
  String manufacturer;
  String style;
  int itemNo;
  int quantity;
    
  public Guitar(String manufacturer, String style, int itemNo, int quantity) {
    this.manufacturer = manufacturer;
    this.style = style;
    this.itemNo = itemNo;
    this.quantity = quantity;
  }
}