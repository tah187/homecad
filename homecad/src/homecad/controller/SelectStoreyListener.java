package homecad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homecad.view.AppFrame;

public class SelectStoreyListener implements ActionListener {
      AppFrame Frame;

      public SelectStoreyListener(AppFrame frame)
      {
         this.Frame = frame;
      }

      public void actionPerformed(ActionEvent e) {
         //get Storey from drop down
         int storey = Frame.getToolView().getStorey()+1;
         //redraw Storey in display
         Frame.getDisplayView().DrawDisplay();
         try {
            int size = Frame.getModel().calculateStoreySize(storey-1);
            //update Status
            Frame.getStatusView().getRoomDetails().setText
               ("Storey "+(storey-1)+" total size: "+size);
         } catch (ArrayIndexOutOfBoundsException oob) {
            
         }

      }

   }
