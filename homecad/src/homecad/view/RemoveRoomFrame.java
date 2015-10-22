package homecad.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import homecad.controller.RemoveRoomController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RemoveRoomFrame extends JFrame {
   
   private JTextField Xcoord = new JTextField(5);
   private JTextField Ycoord = new JTextField(5);
   private JTextField Zcoord = new JTextField(5);
   private StatusView removeRoomStatus;
   
   private AppFrame Frame;
   
   private RemoveRoomController removeRoomController;
   
   public RemoveRoomFrame(AppFrame frame) {

      super("Remove Room");
      removeRoomStatus = new StatusView(this,"");
      
      setSize(300, 150);
      setLocation(300, 300);
      setResizable(false);
      setVisible(true);

      Frame = frame;

      JPanel panel = new JPanel(new GridLayout(0,1));
      JButton Submit = new JButton("Submit");      

      //populate frame
      add(panel, BorderLayout.CENTER);
      JPanel panelone = new JPanel(new GridLayout(0,2));
      JPanel paneltwo = new JPanel(new GridLayout(0,2));
      JPanel panelthree = new JPanel(new GridLayout(0,2));

      panel.add(panelone);
      panel.add(paneltwo);
      panel.add(panelthree);

      panelone.add(new JLabel("Enter X Coordinate:",JLabel.LEFT));
      panelone.add(Xcoord);
      paneltwo.add(new JLabel("Enter Y Coordinate:",JLabel.LEFT));
      paneltwo.add(Ycoord);
      panelthree.add(new JLabel("Enter Storey:",JLabel.LEFT));
      panelthree.add(Zcoord);
      
      panel.add(Submit);
      
      removeRoomController = new RemoveRoomController(this);
      Submit.addActionListener(removeRoomController);

      add(removeRoomStatus, BorderLayout.SOUTH);

   }

    /** getters **/
   public JTextField getXcoord() {
      return Xcoord;
   }

   public JTextField getYcoord() {
      return Ycoord;
   }
   
   public JTextField getZcoord() {
      return Zcoord;
   }

   public AppFrame getFrame() {
      return Frame;
   }
   
   public StatusView getStatusView() {
      return removeRoomStatus;
   }
   /*******************/

   
}
