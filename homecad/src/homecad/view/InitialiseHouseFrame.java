package homecad.view;

import java.awt.BorderLayout;

import homecad.controller.InitialiseHouseController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InitialiseHouseFrame extends JFrame {
   
   private JTextField OwnerName  = new JTextField(20);
   private JTextField Budget = new JTextField(20);
   private StatusView houseStatus;
   
   private AppFrame Frame;
   
   private InitialiseHouseController houseController;
   
   public InitialiseHouseFrame(AppFrame frame) {
      super("Initialise New House");
      houseStatus = new StatusView(this,"");
      
      setSize(300, 175);
      setLocation(300, 300);
      setResizable(false);
      setVisible(true);

      Frame = frame;
      
      JPanel panel = new JPanel();
      JButton Submit = new JButton("Submit");      
      
      //populate frame
      add(panel, BorderLayout.CENTER);

      panel.add(new JLabel("Owner's Name:"));
      panel.add(OwnerName);
      panel.add(new JLabel("Owner's Budget:"));
      panel.add(Budget);
      panel.add(Submit);
      
      houseController = new InitialiseHouseController(this);
      Submit.addActionListener(houseController);

      add(houseStatus, BorderLayout.SOUTH);
   }

    /** getters **/
   public JTextField getOwnerName() {
      return OwnerName;
   }

   public JTextField getBudget() {
      return Budget;
   }

   public AppFrame getFrame() {
      return Frame;
   }
   
   public StatusView getStatusView() {
      return houseStatus;
   }
   /*******************/

   
}
