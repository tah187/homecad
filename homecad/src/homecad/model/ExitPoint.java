package homecad.model;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Exit implementation
//-----------------------------------------------

public class ExitPoint {

   private String Name;
   private RoomReference Destination;
   
   public ExitPoint(RoomReference destination, String name) {
      Name = name;
      Destination = destination;
   }
   
   public RoomReference getDestination() {
      return Destination;
   }
   
   public String getName() {
      return Name;
   }
      
   public String toString() {
      return Name;
   }
}
