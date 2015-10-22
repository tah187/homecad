package homecad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homecad.view.AppFrame;
import homecad.view.InitialiseHouseFrame;

public class InitialiseHouseListener implements ActionListener {
      AppFrame Frame;

      public InitialiseHouseListener(AppFrame frame)
      {
         this.Frame = frame;
      }

      public void actionPerformed(ActionEvent e) {
         new InitialiseHouseFrame(Frame);    
      }

   }
