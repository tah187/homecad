package homecad.model.facade;

import homecad.model.*;
import homecad.model.exception.*;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Engine to implement the systems functionality
//-----------------------------------------------

public class HomeCADengine implements HomeCADmodel {
   
   private Owner Owner;
   private House House;
   

   //creates a new owner with a budget
   public HomeCADengine(String name, int budget) {
      Owner = new Owner(name,budget);
      House = new House(Owner);
   }
   
   public Owner getOwner() {
      return Owner;
   }

   public void addRoom(Room room) throws StructuralException, FinanceException {
      int cost = room.calculateCost();
      if (Owner.assertSufficientBudget(cost)) {
         House.addRoom(room); 
         Owner.decreaseBudget(cost);
      } else {
         throw new FinanceException("Error: Insufficient Funds");
      }
   }

   public void removeRoom(RoomReference location) throws StructuralException {
      int cost = House.removeRoom(location);
      Owner.increaseBudget(cost);
   }

   public Room getRoom(RoomReference location) {
      Room room = House.getRoom(location);
      return room;
   }

   public Room[] getStoreyRooms(int storey) {
      Room[] Storey = House.getAllRooms(storey-1);
      return Storey;
   }

   public Room[] getAllRooms() {
      Room[] rooms = null;
      rooms = House.getAllRooms();
      return rooms;
   }

   public boolean addItem(RoomReference location, Item item)
         throws FinanceException {
      int cost = item.getPrice();
      Room room = House.getRoom(location);
      //check for null reference
      if (room != null) {
         //check for available funds
         if (Owner.assertSufficientBudget(cost)) {
            room.addItem(item); 
            Owner.decreaseBudget(cost);
         } else {
            throw new FinanceException("Error: Insufficient Funds");
         }      
         return true;
      }
      return false;
   }

   public boolean removeItem(RoomReference location, String name) {
      Room room = House.getRoom(location);
      if (room != null) {
         int cost = room.removeItem(name);
         Owner.increaseBudget(cost);
         if (cost != 0) return true;
      }
      return false;
   }

   public void addExitPoint(RoomReference source, RoomReference destination,
         String exitName) throws StructuralException {
      Room Source = House.getRoom(source);
      Room Destination = House.getRoom(destination);
      //check to see source and destination rooms exist
      if (Source != null && Destination!= null) {
         //check X-axis adjacency
         if (source.getX() <= destination.getX()+1 && source.getX() >= destination.getX()-1 && 
               source.getY() <= destination.getY()+1 && source.getY() >= destination.getY()-1 && 
               source.getZ() <= destination.getZ()+1 && source.getZ() >= destination.getZ()-1) {
            Source.addExit(destination, exitName);
            Destination.addExit(source, exitName);
         } else {
            throw new StructuralException("Structural Error: Destination not adjacent to source"); 
         }
      } else {
         throw new StructuralException("Structural Error: Destination room does not exist"); 
      }
   } 

   public void removeExitPoint(RoomReference source, String exitName)
         throws StructuralException {
      Room Source = House.getRoom(source);
      RoomReference destination = Source.getDestinationExit(exitName);
      Room Destination = null;
      if (destination != null) {
         Destination = House.getRoom(destination);
      } else {
         throw new StructuralException("Destination does not exist");
      }
      if (Source != null && Destination != null) {
         Source.removeExit(exitName);
         Destination.removeExit(exitName);
      } else {
         throw new StructuralException("Destination room does not exist"); 
      }
     
   }

   public void reset() {
      House.clearArea();
      Owner.resetBudget();
   }

   public int calculateHouseSize() {
      int size = 0;
      size = House.calculateSize();
      return size;
   }

   public int calculateStoreySize(int storey) {
      Storey target = House.getStorey(storey-1);
      int size = 0;
      if (target != null) {
         size = target.calculateSize();
      }
      return size;
   }

   public int calculateRoomCost(RoomReference location) {
      Room room = House.getRoom(location);
      int cost = 0;
      cost = room.calculateCost();
      return cost;
   }

   public int calculateHouseCost() {
      int cost = 0;
      cost = House.calculateCost();
      return cost;
   }

   public int calculateStoreyCost(int storey) {
      Storey target = House.getStorey(storey-1);
      int cost = 0;
      if (target != null) {
         cost = target.calculateCost();
      }
      System.out.println(cost);
      return cost;
   }

   public int[] getMaxGridSize(int storey) {
      int[] maxGrid = new int[2];
      Storey target = House.getStorey(storey-1);
      maxGrid = target.maxDimensions(storey-1);
      return maxGrid;
   }

   public int getNumberOfStories() {
      return House.getNumStories();
   }
   
   public boolean doesRoomExist(RoomReference test) {
      Storey testFloor = House.getStorey(test.getZ()-1);
      boolean testResult = testFloor.roomExists(test);
      return testResult;
   }

   public RoomReference validateRoomReference (RoomReference location) {
      RoomReference validated = House.getStorey(location.getZ()-1).returnValidReference(location);
      return validated;
   }

}
