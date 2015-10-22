package homecad.model;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Item implementation
//-----------------------------------------------

public abstract class AbstractItem implements Item {
   
   private String Name;

   public AbstractItem (String name) {
      Name = name;
   }
      
   public String getName() {
      return Name;
   }
   public abstract int getPrice();
   public abstract String toString();
    
}

