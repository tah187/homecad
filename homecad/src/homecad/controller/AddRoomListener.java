package homecad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homecad.view.AddRoomFrame;
import homecad.view.AppFrame;

public class AddRoomListener implements ActionListener {
      AppFrame Frame;

      public AddRoomListener(AppFrame frame)
      {
         this.Frame = frame;
      }

      public void actionPerformed(ActionEvent e) {
         new AddRoomFrame(Frame);    
      }

   }
