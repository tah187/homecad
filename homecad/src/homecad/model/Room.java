package homecad.model;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Room implementation
//-----------------------------------------------

public interface Room extends Buildable{
   public final int SQMCOST = 10;
   
   public void addExit(RoomReference destination, String name);
   
   public boolean addItem(Item item);
   
   public int removeItem(String name);
   
   public ExitPoint getExit(String name);
   
   public ExitPoint[] getExitList();

   public Item getItem(String name);

   public Item[] getItemList();

   public RoomReference getLocation();

   public String getName();

   public void removeExit(String name);

   public String toString();

   public RoomReference getDestinationExit(String name);
}
