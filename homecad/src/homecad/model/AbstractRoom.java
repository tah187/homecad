package homecad.model;

import java.util.ArrayList;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Room implementation
//-----------------------------------------------

public abstract class AbstractRoom {
   
   private RoomReference Location;
   private String Name;
   private ArrayList<ExitPoint> Exits;
   protected ArrayList<Item> Items;
   
   public AbstractRoom (RoomReference location, String name) {
      Location = location;
      Name = name;
      Exits = new ArrayList<ExitPoint>();
      Items = new ArrayList<Item>();
   }
   
   public String getName() {
      return Name;
   }
   
   public RoomReference getLocation() {
      return Location;
   }
   
   public void addExit(RoomReference destination, String name) {
      ExitPoint exit = new ExitPoint(destination, name);
      Exits.add(exit);
   }
   
   public boolean addItem(Item item) {
      Items.add(item);
      return false;
   }
   
   public ExitPoint getExit(String name){
      ExitPoint exit = null;
      for (int i = 0; i < Exits.size(); i++){
         //check for referenced exit name
         if (Exits.get(i).getName().equals(name)) 
            exit = Exits.get(i);
      }
      return exit;
   }
   
   public RoomReference getDestinationExit(String name){
      ExitPoint Destination = getExit(name);
      RoomReference destination = null;
      if (Destination != null) {
         destination = Destination.getDestination();
      }
      return destination;
   }

   public ExitPoint[] getExitList() {
      ExitPoint[] allExits = Exits.toArray( new ExitPoint[ Exits.size() ] );
      return allExits;      
   }
   
   public Item getItem(String name) {
      Item item = null;
      for (int i = 0; i < Items.size(); i++){
         if (Items.get(i).getName().equals(name)) 
            item = Items.get(i);
       }
      return item;
   }

   public Item[] getItemList() {
      Item[] allItems = Items.toArray( new Item[ Items.size() ] );
      return allItems;      
   }
   
   public void removeExit(String name) {
      ExitPoint target = getExit(name);
      int index = Exits.indexOf(target);
      if (index != -1) {
         Exits.remove(index);
      }
   }
   
   public int removeItem(String name) {
      Item target = getItem(name);
      int index = Items.indexOf(target);
      if (index != -1) {
         int cost = target.getPrice();
         Items.remove(index);
         return cost;
      }
      return 0;
   }

   public String itemsToString(){
      String items = "";
      for (int i = 0; i < Items.size(); i++){
         items = items + Items.get(i).toString();
         if (i != Items.size()) items = items + ",";
      }
      return items;
   }
   
   public String exitsToString(){
      String exits = "";
      for (int i = 0; i < Exits.size(); i++){
         exits = exits + Exits.get(i).toString();
         if (i != Exits.size()) exits = exits + ",";
      }
      return exits;
   }   
   
   public abstract String toString();

   public void clearArea() {
      Exits.clear();
      Items.clear();
   }
}

