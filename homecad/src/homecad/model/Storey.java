package homecad.model;

import homecad.model.exception.*;

import java.util.*;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Storey implementation
//-----------------------------------------------

public class Storey implements Buildable{
   
//   private ArrayList<Room> Rooms;
   private Map<RoomReference, Room> Rooms;
   
   public Storey () {
      Rooms = new HashMap<RoomReference, Room>();
   }
   
   public void addRoom(Room room)  throws StructuralException {
      RoomReference location = room.getLocation();
      //check for valid location
      if (isReferenceValid(location)) {
         Rooms.put(location, room);
      } else {
         throw new StructuralException("Structural Error: Room Already Exists at Location"); 
      }
   }
   
   public Room[] getAllRooms() {
      Room[] allRooms = Rooms.values().toArray( new Room[ Rooms.size()] );
      return allRooms;      
   }

   
   public Room getRoom(RoomReference location) {
      Room room = null;
      room = Rooms.get(location);
      return room;
   }
   
   public int[] maxDimensions(int storey) {
      int[] maxGrid = new int[2];
      Room[] rooms = getAllRooms(); 

      //search for maximum x dimension and y dimension
      for (int i = 0; i < rooms.length; i++) {
         //check dimension of current room vs maximum X dimension
         if (rooms[i].getLocation().getX() > maxGrid[1]) {
            maxGrid[1] = rooms[i].getLocation().getX();
         }
         //check dimension of current room vs maximum X dimension
         if (rooms[i].getLocation().getY() > maxGrid[0]) {
            maxGrid[0] = rooms[i].getLocation().getY();
         }
      }
      return maxGrid;
   }

   public int removeRoom(RoomReference location) {
      int cost = 0;
      RoomReference validlocation = returnValidReference(location);
      cost = Rooms.get(validlocation).calculateCost();
      Rooms.remove(validlocation);
      return cost;
   }
   
   public RoomReference returnValidReference (RoomReference location) {
      String loc = location.toString();
      Room[] rooms = getAllRooms();
      for (int i=0; i < rooms.length; i++) {
         String test = rooms[i].getLocation().toString();
         if (loc.equals(test)) return rooms[i].getLocation();
      }
      return location;
   }
   
   private boolean isReferenceValid(RoomReference location) {
      int X = location.getX();
      int Y = location.getY();
      int Z = location.getZ();
      //check for negative values
      if (X < 0 || Y < 0 || Z < 0) return false;
      //check to see if room already exists
      if (roomExists(location))return false;
      return true;
   }
   
   public boolean roomExists(RoomReference location) {
      String loc = location.toString();
      Room[] rooms = getAllRooms();
      for (int i=0; i < rooms.length; i++) {
         String test = rooms[i].getLocation().toString();
         if (loc.equals(test)) return true;
      }
      return false;
   }

   public int calculateCost() {
      int cost = 0;
      Room[] rooms = getAllRooms();
      //get each room size and add to total
      for (int i =0; i < rooms.length; i++) {
         cost = cost + rooms[i].calculateCost();
      }
      return cost;
   }

   public int calculateSize() {
      int size = 0;
      Room[] rooms = getAllRooms();
      //get each room size and add to total
      for (int i =0; i < rooms.length; i++) {
         size = size + rooms[i].calculateSize();
      }
      return size;
   }

   public void clearArea() {
      //clear all exits and items from the rooms
      for (int i = 0; i < 0; i++){
         Rooms.get(i).clearArea();
      }
      Rooms.clear();
   }
}
