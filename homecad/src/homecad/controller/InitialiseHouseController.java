package homecad.controller;

import homecad.model.facade.HomeCADengine;
import homecad.view.InitialiseHouseFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class InitialiseHouseController implements ActionListener {
   
   private InitialiseHouseFrame HouseFrame;
   
   public InitialiseHouseController (InitialiseHouseFrame houseFrame) {
      this.HouseFrame = houseFrame;
   }

   public void actionPerformed(ActionEvent e) {
      // Retrieve user inputed information
      String owner = HouseFrame.getOwnerName().getText();
      boolean validation = true; 
      int validBudget = 0;
      
      //Validate input - Owner not null
      if (owner.equals("")) {
         JOptionPane.showMessageDialog(HouseFrame, "Error: Owner's name not entered.");
         HouseFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }

      //Validate input - Ensure budget is a number
      try {
         validBudget = Integer.parseInt(HouseFrame.getBudget().getText().trim());
      } catch (NumberFormatException nfe){
         JOptionPane.showMessageDialog(HouseFrame, "Error: Budget must be a number");
         HouseFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }
      
      //Ensure Coordinates are in a valid range
      if (validBudget <= 0) {
         JOptionPane.showMessageDialog(HouseFrame, "Error: Budget must be non-zero and positive");
         HouseFrame.getStatusView().getCurrentStatus().setText ("Error");
         validation = false;
      }
      
      if (validation) {
         //initialise HomeCAD Engine
         HomeCADengine model = new HomeCADengine(owner, validBudget);
         HouseFrame.getFrame().setModel(model);
         //update main status view with information
         HouseFrame.getFrame().getStatusView().getCurrentStatus().setText
            ("HomeCAD engine initialised with Owner: "+owner+", and budget of $"+validBudget);
         //close input window
         HouseFrame.setVisible(false);
      }
    
      }
}

