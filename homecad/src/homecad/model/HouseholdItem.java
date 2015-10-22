package homecad.model;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Item implementation
//-----------------------------------------------

public class HouseholdItem extends AbstractItem {

   private int Price;

   public HouseholdItem(String name, int price) {
      super(name);
      Price = price;
   }
   
   public int getPrice() {
      return Price;
   }

   public String toString() {
      return this.getName() + "-" + Price;
   }

}