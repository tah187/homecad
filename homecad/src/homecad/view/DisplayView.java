package homecad.view;

import homecad.controller.AddRoomDisplayListener;
import homecad.controller.DisplayViewListener;
import homecad.model.RectangularRoom;
import homecad.model.RoomReference;
import homecad.model.facade.HomeCADengine;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayView extends JPanel {
   
   //Local frame instance
   private AppFrame Frame;
   private final int BASEUNIT = 10;

   public DisplayView(AppFrame frame) {
      Frame = frame;
      
      DrawDisplay();
      
   }
   
   public void DrawDisplay() {
      //remove all existing components
      this.removeAll();
      int storey = Frame.getToolView().getStorey();
      int zoom = Frame.getToolView().getZoom();
      double scale = (double)zoom/100;
      HomeCADengine model = Frame.getModel();
      boolean validation = true;
      try {
         int[] gridYX = model.getMaxGridSize(storey);
      } catch (IndexOutOfBoundsException oob) {
         validation = false;
      } catch (NullPointerException npe) {
         validation = false;
      }
      //check to see if house has been initialised and rooms exist
      //check if storey array is populated
      if (storey > 0 && validation == true) {
         //Get Grid Size
         int[] gridYX = model.getMaxGridSize(storey);
         GridLayout storeyLayout = new GridLayout(gridYX[0],gridYX[1]);
         int size = gridYX[0]*gridYX[1];
         this.setLayout(storeyLayout);
         //draw each grid as a button
         for (int i=1; i <= size ; i++ ) {
            //determine Cartesian coordinates for grid square 
            int Y = (size/gridYX[1])-((i-1)/gridYX[1]);
            int X = i-((gridYX[0]-Y)*gridYX[1]);
            //Create a location reference to test against the storey structure
            RoomReference location = new RoomReference(X,Y,storey);
            //check to see if a room exists for location
            if (model.doesRoomExist(location)){
               //parse reference
               location = model.validateRoomReference(location);
               //get Room
               final RectangularRoom drawRoom = (RectangularRoom) model.getRoom(location);
               
               //create room size variables
               double Length = 0;
               double Width = 0;
               //populate size variables from room
               if (drawRoom != null) {
                  Length = drawRoom.getLength()*scale*BASEUNIT;
                  Width = drawRoom.getWidth()*scale*BASEUNIT;
               }
               
               //draw room
               RoomPanel room = new RoomPanel(Length,Width); 
               JScrollPane scrollPane = new JScrollPane(room);
               
               scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
               scrollPane.getViewport().add(room, null);
               add(scrollPane);
               
               //coord label
               room.add(new JLabel("("+X+","+Y+")"));
               
               //Alt-Click to Remove room
               DisplayViewListener displayViewListener = new DisplayViewListener(Frame,drawRoom.toString(),X,Y,storey);
               room.addMouseListener(displayViewListener);

               
            } else {
               //create empty panel
               JButton blankButton = new JButton();
               AddRoomDisplayListener addRoomListener = new AddRoomDisplayListener(Frame,X,Y,storey);
               blankButton.addActionListener(addRoomListener);
               this.add(blankButton);
            }
         }
      } else {
         JPanel clear = new JPanel();
         clear.setVisible(true);
         add(clear);
      }
      //redraw
      this.revalidate();
   }

}
