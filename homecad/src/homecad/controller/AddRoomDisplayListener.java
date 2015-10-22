package homecad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homecad.view.AddRoomFrame;
import homecad.view.AppFrame;

public class AddRoomDisplayListener implements ActionListener {
      AppFrame Frame;
      int X;
      int Y;
      int Z;

      public AddRoomDisplayListener(AppFrame frame, int x, int y, int z)
      {
         this.Frame = frame;
         X = x;
         Y = y;
         Z = z;
      }
      
      public void actionPerformed(ActionEvent e) {
         new AddRoomFrame(Frame, X, Y, Z);    
      }

   }
