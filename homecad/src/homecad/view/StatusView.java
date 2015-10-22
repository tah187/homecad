package homecad.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusView extends JPanel {
   private JLabel currentStatus;
   private JLabel roomDetails;
  
   public StatusView(JFrame frame, String initialStatus) {
      setLayout(new BorderLayout());
      
      currentStatus = new JLabel(initialStatus);
      roomDetails = new JLabel("");
      
      currentStatus.setVerticalAlignment(JLabel.TOP);
      currentStatus.setHorizontalAlignment(JLabel.LEFT);
      currentStatus.setPreferredSize(new Dimension(500, 20));

      roomDetails.setVerticalAlignment(JLabel.TOP);
      roomDetails.setHorizontalAlignment(JLabel.RIGHT);
      roomDetails.setPreferredSize(new Dimension(300, 10));
      
      add(currentStatus, BorderLayout.WEST);
      add(roomDetails, BorderLayout.EAST);
   }
   
   public JLabel getCurrentStatus() {
      return currentStatus;
   }
   
   public JLabel getRoomDetails() {
      return roomDetails;
   }
   
   
   
}
