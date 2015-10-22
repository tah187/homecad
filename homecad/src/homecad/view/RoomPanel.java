package homecad.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class RoomPanel extends JPanel{
   
   private int Length;
   private int Width;
   
   public RoomPanel (double length, double width) {
      super();
      Length = (int) length;
      Width = (int) width;
      setPreferredSize(new Dimension(Length+5, Width+5));
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g); 

      Graphics2D g2d = (Graphics2D) g;

      g2d.setColor(new Color(125, 167, 116));
      g2d.fillRect(5, 5, Length, Width);

   }

}
