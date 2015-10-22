package homecad.model;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Item implementation
//-----------------------------------------------

public class ElectronicAppliance extends AbstractItem {
   
   private int Price;
   private final int INSTALATION = 15;
   
   public ElectronicAppliance(String name, int price) {
      super(name);
      Price = price;
   }

   public int getPrice() {
      int price = Price + INSTALATION;
      return price;
   }

   public String toString() {
      return this.getName() + "-" + Price + "-" + INSTALATION;
   }

}