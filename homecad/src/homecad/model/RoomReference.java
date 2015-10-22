package homecad.model;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Room implementation
//-----------------------------------------------

public class RoomReference {
   private int X;
   private int Y;
   private int Z;

   public RoomReference (int x, int y, int z) {
      X = x;
      Y = y;
      Z = z;
   }

   public int getX() {
      return X;
   }

   public int getY() {
      return Y;
   }

   public int getZ() {
      return Z;
   }
   
   public String toString() {
      return X + "," + Y + "," + Z;
   }

}
