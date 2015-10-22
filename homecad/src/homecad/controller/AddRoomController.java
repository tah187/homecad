package homecad.controller;

import homecad.model.RoomReference;
import homecad.model.RectangularRoom;
import homecad.model.exception.HomeCADException;
import homecad.model.facade.HomeCADengine;
import homecad.view.AddRoomFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class AddRoomController implements ActionListener {
   
   private AddRoomFrame AddRoomFrame;
   
   public AddRoomController (AddRoomFrame addRoomFrame) {
      this.AddRoomFrame = addRoomFrame;
   }

   public void actionPerformed(ActionEvent e) {
      // Retrieve user inputed information
      String roomName = AddRoomFrame.getRoomName().getText();
      boolean validation = true; 
      int validX = 0;
      int validY = 0;
      int validZ = 0;
      int sizeX = 0;
      int sizeY = 0;
      int sizeZ = 0;
      
     //Validate input - Ensure coordinated are integers
      try {
         validX = Integer.parseInt(AddRoomFrame.getXcoord().getText().trim());
         validY = Integer.parseInt(AddRoomFrame.getYcoord().getText().trim());
         validZ = Integer.parseInt(AddRoomFrame.getZcoord().getText().trim());
      } catch (NumberFormatException nfe){
         JOptionPane.showMessageDialog(AddRoomFrame, "Error: Coordinates must be a number");
         AddRoomFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }
      
      //Ensure Coordinates are in a valid range
      if (validX <= 0 || validY <= 0 || validZ <= 0) {
         JOptionPane.showMessageDialog(AddRoomFrame, "Error: Coordinates must be non-zero and positive");
         AddRoomFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }

      //Validate input - Ensure sizes are integers

      try {
         sizeX = Integer.parseInt(AddRoomFrame.getSizeX().getText().trim());
         sizeY = Integer.parseInt(AddRoomFrame.getSizeY().getText().trim());
         sizeZ = Integer.parseInt(AddRoomFrame.getSizeZ().getText().trim());
         
      } catch (NumberFormatException nfe){
         JOptionPane.showMessageDialog(AddRoomFrame, "Error: Sizes must be a number");
         AddRoomFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }
      
      //Ensure sizes are in a valid range
      if (sizeX <= 0 || sizeY <= 0 || sizeZ <= 0) {
         JOptionPane.showMessageDialog(AddRoomFrame, "Error: Sizes must be non-zero and positive");
         AddRoomFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }
      
      //Validate input - Ensure there is a name
      if (roomName.equals("")) {
         JOptionPane.showMessageDialog(AddRoomFrame, "Error: Name not Entered");
         AddRoomFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }
      if (validation) {
         //load model
         HomeCADengine model = AddRoomFrame.getFrame().getModel();
         //create RoomReference
         RectangularRoom newRoom = new RectangularRoom(new RoomReference(validX, validY, validZ),roomName,sizeX,sizeY,sizeZ);
         //add Room to House
         try {
            model.addRoom(newRoom);
            AddRoomFrame.getFrame().getToolView().setStorey();

            //redraw Display
            AddRoomFrame.getFrame().getDisplayView().DrawDisplay();
            //update main status with information
            String owner = model.getOwner().getName();
            int totalBudget = model.getOwner().getTotalBudget();
            int availBudget = model.getOwner().getAvailableBudget();

            AddRoomFrame.getFrame().getStatusView().getCurrentStatus().setText
            (owner+", initial budget: $"+totalBudget+", available budget: $"+availBudget+
            		"    Room Added At: ("+validX+","+validX+")");
            AddRoomFrame.getFrame().getStatusView().getRoomDetails().setText("");
            //close input window
            AddRoomFrame.setVisible(false);
         } catch (HomeCADException hce) {
            JOptionPane.showMessageDialog(AddRoomFrame, hce);
            AddRoomFrame.getStatusView().getCurrentStatus().setText("Error");
         } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(AddRoomFrame, "House not initialised");
            AddRoomFrame.getStatusView().getCurrentStatus().setText("Error");
         } catch (IndexOutOfBoundsException npe) {
            JOptionPane.showMessageDialog(AddRoomFrame, "Invalid Storey");
            AddRoomFrame.getStatusView().getCurrentStatus().setText("Error");
         }
      }
   }
}

