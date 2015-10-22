package homecad.model.facade;

import homecad.model.*;
import homecad.model.exception.*;

//-----------------------------------------------
//Programming 2 -- OUA Term 4, 2010
//-----------------------------------------------
//Interface to the system functionality (model)
//-----------------------------------------------

public interface HomeCADmodel {

  public Owner getOwner();

  public void addRoom(Room room) throws StructuralException, FinanceException;

  public void removeRoom(RoomReference location) throws StructuralException;

  public Room getRoom(RoomReference location);

  public Room[] getStoreyRooms(int storey);

  public Room[] getAllRooms();

  public boolean addItem(RoomReference location, Item item)
      throws FinanceException;

  public boolean removeItem(RoomReference location, String name);

  public void addExitPoint(RoomReference source, RoomReference destination,
      String exitName) throws StructuralException;

  public void removeExitPoint(RoomReference source, String exitName)
      throws StructuralException;

  public void reset();

  public int calculateHouseSize();

  public int calculateStoreySize(int storey);

  public int calculateRoomCost(RoomReference location);

  public int calculateHouseCost();

  public int calculateStoreyCost(int storey);

/* this returns an array containing 2 ints, with the first element indicating the number of rows, and the second element the number of columns for a given storey. */
  public int[] getMaxGridSize(int storey); 

  public int getNumberOfStories();
  
  public boolean doesRoomExist(RoomReference test);
  
  public RoomReference validateRoomReference (RoomReference location);
 }
