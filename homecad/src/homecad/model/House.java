package homecad.model;

import homecad.model.exception.FinanceException;
import homecad.model.exception.StructuralException;

import java.util.ArrayList;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//House implementation
//-----------------------------------------------


public class House implements Buildable {
   
   private Owner Owner;
   private ArrayList<Storey> Storeys;
   
   public House (Owner owner) {
      Owner = owner;
      Storeys = new ArrayList<Storey>();
   }
   
   public void addRoom(Room room) throws StructuralException, FinanceException  {
      int storey = findStorey(room.getLocation()) - 1;
      //checks for structural integrity
      if (storey < 0) {
         throw new StructuralException("Structural Error: invalid reference");
      }
      if (!checkLowerStructuralSupport(room.getLocation()))
         throw new StructuralException("Structural Exception: Room not supported below");

      //checks Z axis to determine level. If floor does not exist, initialises.
      if (storey == 0 && Storeys.size() == 0) {
         this.addStorey();
      }
      if (storey == 1 && Storeys.size() == 1) {
         this.addStorey();
      }
      if (storey == 2 && Storeys.size() == 2) {
         this.addStorey();
      }
      if (storey > 2) throw new StructuralException("Structural Exception: Building at Maximum Allowable Height");

      Storeys.get(storey).addRoom(room);
   }
   
   private void addStorey() {
      Storey storey = new Storey();
      Storeys.add(storey);
   }

   public int calculateCost() {
      int cost = 0;
      //get the cost for each storey and add to running total
      for (int i = 0; i < Storeys.size(); i++) {
         cost = cost + Storeys.get(i).calculateCost();
      }
      return cost;
   }

   public int calculateSize() {
      int size = 0;
      //get the size for each storey and add to the running total
      for (int i = 0; i < Storeys.size(); i++) {
         size = size + Storeys.get(i).calculateSize();
      }
      return size;
   }

   public void clearArea() {
      for (int i = 0; i < Storeys.size(); i++){
         Storeys.get(i).clearArea();
      }
      Storeys.clear();
   }

   public int findStorey(RoomReference location) {
      int storey = location.getZ();
      return storey;
   }
     
   public Room[] getAllRooms() {
      Room[][] storey = new Room[2][];
      int length = 0;
      if (Storeys.size() == 0) {
         return null;
      }
      for (int i = 0; i < Storeys.size(); i++) {
         storey[i] = Storeys.get(i).getAllRooms();
         length = length + storey[i].length;
      }
      //Takes rooms from each floor and joins them into one
      Room[] allRooms = new Room[length];
      System.arraycopy(storey[0], 0, allRooms, 0, storey[0].length);
      for (int i = 1; i < Storeys.size(); i++) {
         System.arraycopy(storey[i], 0, allRooms, storey[i-1].length, storey[i].length);
      } 
      if (length == 0) {
         return null;
      }
      return allRooms;
   }
   
   public Room[] getAllRooms(int storey) {
      if (Storeys.size() == 0) {
         return null;
      }
      Room[] storeyRooms = Storeys.get(storey).getAllRooms();
      if (storeyRooms.length == 0 ) {
         return null;
      }
      return storeyRooms;
   }
   
   public int getNumStories() {
      return Storeys.size();
   }
   
   public Owner getOwner() {
      return Owner;
   }
   
   public Room getRoom(RoomReference location) {
      int storey = location.getZ() - 1;
      Room temp = null;
      if (Storeys.size() != 0 && storey < Storeys.size()) {
         temp = Storeys.get(storey).getRoom(location);
      }
      return temp;
   }
    
   public Storey getStorey(int storey){
      Storey target = null;
      if (this.getNumStories() >= storey) {
         target = Storeys.get(storey);
      }
      return target;
      
   }
   
   public int removeRoom(RoomReference location) throws StructuralException {
      int cost = 0;
      int index = findStorey(location)-1;
      //check to see if room location is on a valid reference
      if (index > Storeys.size() || index < 0) {
         throw new StructuralException("Structural Error: invalid reference");
      }
      //check to see if there is a room supported above
      if (checkUpperStructuralSupport(location)) {
         throw new StructuralException("Structural Error: Room supporting existing structure");
      }

      cost = Storeys.get(index).removeRoom(location);

      //if no more rooms on the top floor, delete top floor
      if (getAllRooms(getNumStories()-1) == null) {
         removeStorey();
      }
      return cost;
   }
   
   private void removeStorey() {
      Storeys.remove(getNumStories()-1);
   }
   
   private boolean checkLowerStructuralSupport(RoomReference location) {
      int storey = location.getZ();
      //check to see if on the ground floor
      if (storey == 1) return true; 
      //new testing reference to test the floor below
      RoomReference check = new RoomReference(location.getX(),location.getY(),location.getZ()-1);
      if (Storeys.get(storey-2).roomExists(check)) {
         return true;
      }
      return false;
   }

   private boolean checkUpperStructuralSupport(RoomReference location) {

      int storey = location.getZ();
      //check to see if already on the top floor
      if (storey == Storeys.size()) return false;
      //new testing reference 1 z-floor above
      RoomReference check = new RoomReference(location.getX(),location.getY(),location.getZ()+1);
      if (Storeys.get(storey).roomExists(check)) {
         return true;
      }
      return false;
   }

}
