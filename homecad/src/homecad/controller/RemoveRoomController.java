package homecad.controller;

import homecad.model.RoomReference;
import homecad.model.exception.HomeCADException;
import homecad.model.facade.HomeCADengine;
import homecad.view.AppFrame;
import homecad.view.RemoveRoomFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class RemoveRoomController implements ActionListener {
   
   private RemoveRoomFrame RemoveRoomFrame;
   
   public RemoveRoomController (RemoveRoomFrame removeRoomFrame) {
      this.RemoveRoomFrame = removeRoomFrame;
   }

   public void actionPerformed(ActionEvent e) {
      // Retrieve user inputed information
      boolean validation = true; 
      int validX = 0;
      int validY = 0;
      int validZ = 0;
      
      //Validate input - Ensure coordinated are integers
      try {
         validX = Integer.parseInt(RemoveRoomFrame.getXcoord().getText().trim());
         validY = Integer.parseInt(RemoveRoomFrame.getYcoord().getText().trim());
         validZ = Integer.parseInt(RemoveRoomFrame.getZcoord().getText().trim());
      } catch (NumberFormatException nfe){
         JOptionPane.showMessageDialog(RemoveRoomFrame, "Error: Coordinates must be a number");
         RemoveRoomFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }
      
      //Ensure Coordinates are in a valid range
      if (validX <= 0 || validY <= 0 || validZ <= 0) {
         JOptionPane.showMessageDialog(RemoveRoomFrame, "Error: Coordinates must be non-zero and positive");
         RemoveRoomFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }

      if (validation) RemoveRoom(validX, validY, validZ);
         
     
        
   }
   
   public void RemoveRoom(int X, int Y, int Z) {
      //load model
      HomeCADengine model = RemoveRoomFrame.getFrame().getModel();
      //create RoomReference
      RoomReference location = new RoomReference(X, Y, Z);
      //Prompt user for confirmation
      int reply = JOptionPane.showConfirmDialog(RemoveRoomFrame,
            "Are you sure you want to remove the room?", "Remove Room?", JOptionPane.YES_NO_OPTION);
      if (reply == JOptionPane.YES_OPTION) {
         //Remove Room
         try {
            model.removeRoom(location);
            //recalculate Storey dropdown
            RemoveRoomFrame.getFrame().getToolView().setStorey();
            //redraw Display
            RemoveRoomFrame.getFrame().getDisplayView().DrawDisplay();
            //update main status with information
            RemoveRoomFrame.getFrame().getStatusView().getCurrentStatus().setText(getOwnerBudget(model));
            RemoveRoomFrame.getFrame().getStatusView().getRoomDetails().setText
            ("Room Removed At: ("+X+","+Y+","+Z+")");
            //close input window
            RemoveRoomFrame.setVisible(false);
         } catch (HomeCADException hce) {
            JOptionPane.showMessageDialog(RemoveRoomFrame, hce);
            RemoveRoomFrame.getStatusView().getCurrentStatus().setText("Error");
         }  catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(RemoveRoomFrame, "House not initialised");
            RemoveRoomFrame.getStatusView().getCurrentStatus().setText("Error");
         } catch (IndexOutOfBoundsException npe) {
            JOptionPane.showMessageDialog(RemoveRoomFrame, "Room does not exist");
            RemoveRoomFrame.getStatusView().getCurrentStatus().setText("Error");
         }
      }      
   }

   public static void RemoveRoom(AppFrame frame, int X, int Y, int Z) {
      //load model
      HomeCADengine model = frame.getModel();
      //create RoomReference
      RoomReference location = new RoomReference(X, Y, Z);
      //Prompt user for confirmation
      int reply = JOptionPane.showConfirmDialog(frame,
           "Are you sure you want to remove the room?", "Remove Room?", JOptionPane.YES_NO_OPTION);
      if (reply == JOptionPane.YES_OPTION) {
           //Remove Room
           try {
              model.removeRoom(location);
              //recalculate Storey dropdown
              frame.getToolView().setStorey();
              //redraw Display
              frame.getDisplayView().DrawDisplay();
              //update main status with information
              frame.getStatusView().getCurrentStatus().setText(getOwnerBudget(model));
              frame.getStatusView().getRoomDetails().setText("Room Removed At: ("+X+","+Y+","+Z+")");
          } catch (HomeCADException hce) {
             JOptionPane.showMessageDialog(frame, hce);
          }
      }
   }
   
   public static String getOwnerBudget(HomeCADengine model) {
      String owner = model.getOwner().getName();
      int totalBudget = model.getOwner().getTotalBudget();
      int availBudget = model.getOwner().getAvailableBudget();
      return (owner+", initial budget: $"+totalBudget+", available budget: $"+availBudget);
   }
}

