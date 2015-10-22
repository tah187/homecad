package homecad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homecad.view.AppFrame;
import homecad.view.RemoveRoomFrame;

public class RemoveRoomListener implements ActionListener {
      AppFrame Frame;

      public RemoveRoomListener(AppFrame frame)
      {
         this.Frame = frame;
      }

      public void actionPerformed(ActionEvent e) {
         new RemoveRoomFrame(Frame);    
      }

   }
