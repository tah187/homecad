package homecad.controller;

import homecad.view.AppFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DisplayViewListener implements MouseListener{
   
   private AppFrame Frame;
   private String Room;
   private int X;
   private int Y;
   private int Z;
   
   public DisplayViewListener (AppFrame frame, String room, int x, int y, int z) {
      this.Frame = frame;
      Room = room;
      X = x;
      Y = y; 
      Z = z;
   }
   
   
   public void mouseClicked(MouseEvent e) {
      Frame.getStatusView().getRoomDetails().setText("Room Details: "+Room);
      
      if(e.isAltDown()) {
         RemoveRoomController.RemoveRoom(Frame,X,Y,Z);
      }
   }
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mousePressed(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}

}
