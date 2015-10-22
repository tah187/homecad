package homecad.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import homecad.controller.AddRoomController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddRoomFrame extends JFrame {
   
   private JTextField Xcoord = new JTextField(5);
   private JTextField Ycoord = new JTextField(5);
   private JTextField Zcoord = new JTextField(5);
   private JTextField RoomName = new JTextField(15);
   private JTextField SizeX = new JTextField(5);
   private JTextField SizeY = new JTextField(5);
   private JTextField SizeZ = new JTextField(5);
   private StatusView addRoomStatus;
   
   private AppFrame Frame;
   
   private AddRoomController addRoomController;
   
   public AddRoomFrame(AppFrame frame) {
     
      super("Add a New Room");
      addRoomStatus = new StatusView(this,"");
      
      setSize(300, 250);
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
      JPanel panelfour = new JPanel(new GridLayout(0,2));
      JPanel panelfive = new JPanel(new GridLayout(0,2));
      JPanel panelsix = new JPanel(new GridLayout(0,2));
      JPanel panelseven = new JPanel(new GridLayout(0,2));
      
      panel.add(panelone);
      panel.add(paneltwo);
      panel.add(panelthree);
      panel.add(panelfour);
      panel.add(panelfive);
      panel.add(panelsix);
      panel.add(panelseven);
      
      panelone.add(new JLabel("Enter X Coordinate:"));
      panelone.add(Xcoord);
      paneltwo.add(new JLabel("Enter Y Coordinate:"));
      paneltwo.add(Ycoord);
      panelthree.add(new JLabel("Enter Storey:"));
      panelthree.add(Zcoord);
      panelfour.add(new JLabel("Enter Room Name:"));
      panelfour.add(RoomName);
      panelfive.add(new JLabel("Enter Room Length:"));
      panelfive.add(SizeX);
      panelsix.add(new JLabel("Enter Room Width:"));
      panelsix.add(SizeY);
      panelseven.add(new JLabel("Enter Room Height:"));
      panelseven.add(SizeZ);
      panel.add(Submit);

      addRoomController = new AddRoomController(this);
      Submit.addActionListener(addRoomController);

      add(addRoomStatus, BorderLayout.SOUTH);
   }

   public AddRoomFrame(AppFrame frame, int X, int Y, int Z) {
      super("Add a New Room");
      
      Xcoord = new JTextField(Integer.toString(X),5);
      Xcoord.setEditable(false);
      Ycoord = new JTextField(Integer.toString(Y),5);
      Ycoord.setEditable(false);
      Zcoord = new JTextField(Integer.toString(Z),5);
      Zcoord.setEditable(false);
      
      addRoomStatus = new StatusView(this,"");
      
      setSize(300, 250);
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
      JPanel panelfour = new JPanel(new GridLayout(0,2));
      JPanel panelfive = new JPanel(new GridLayout(0,2));
      JPanel panelsix = new JPanel(new GridLayout(0,2));
      JPanel panelseven = new JPanel(new GridLayout(0,2));
      
      panel.add(panelone);
      panel.add(paneltwo);
      panel.add(panelthree);
      panel.add(panelfour);
      panel.add(panelfive);
      panel.add(panelsix);
      panel.add(panelseven);
      
      panelone.add(new JLabel("Enter X Coordinate:"));
      panelone.add(Xcoord);
      paneltwo.add(new JLabel("Enter Y Coordinate:"));
      paneltwo.add(Ycoord);
      panelthree.add(new JLabel("Enter Storey:"));
      panelthree.add(Zcoord);
      panelfour.add(new JLabel("Enter Room Name:"));
      panelfour.add(RoomName);
      panelfive.add(new JLabel("Enter Room Length:"));
      panelfive.add(SizeX);
      panelsix.add(new JLabel("Enter Room Width:"));
      panelsix.add(SizeY);
      panelseven.add(new JLabel("Enter Room Height:"));
      panelseven.add(SizeZ);
      panel.add(Submit);

      addRoomController = new AddRoomController(this);
      Submit.addActionListener(addRoomController);

      add(addRoomStatus, BorderLayout.SOUTH);
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

   public JTextField getRoomName() {
      return RoomName;
   }

   public JTextField getSizeX() {
      return SizeX;
   }
   
   public JTextField getSizeY() {
      return SizeY;
   }

   public JTextField getSizeZ() {
      return SizeZ;
   }
   
   public AppFrame getFrame() {
      return Frame;
   }
   
   public StatusView getStatusView() {
      return addRoomStatus;
   }
   /*******************/

   
}
