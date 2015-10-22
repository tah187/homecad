package homecad.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import homecad.view.AppFrame;

public class NewActionListener implements ActionListener
{
   AppFrame frame;

   public NewActionListener(AppFrame frame)
   {
      super();
      this.frame = frame;
   }

   @Override
   public void actionPerformed(ActionEvent arg0)
   {
   }

}
