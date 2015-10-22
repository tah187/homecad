package homecad.model;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Room implementation
//-----------------------------------------------

public class RectangularRoom extends AbstractRoom implements Room {
   
   private int Length;
   private int Width;
   private int Height;
   
   public RectangularRoom(RoomReference location, String name, int length, int width, int height) {
      super(location, name);
      Length = length;
      Width = width;
      Height = height;
   }

   public int calculateCost() {
      int cost = this.calculateSize() * SQMCOST;
      for (int i = 0; i < Items.size(); i++) {
         cost = cost + Items.get(i).getPrice();
      }
      return cost;
   }
   
   public int calculateSize() {
      int size = this.getLength() * this.getWidth() * this.getHeight();
      return size;
   }
   
   public int getLength() {
      return Length;
   }

   public int getWidth() {
      return Width;
   }

   public int getHeight() {
      return Height;
   }
   
   public String toString() {
      RoomReference location = this.getLocation();
      return location.toString() + ":" + Length + "," + Width + "," + Height + ":" + this.getName() + ":" + this.itemsToString() + ":" + this.exitsToString();
   }


   
}