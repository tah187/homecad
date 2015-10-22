package homecad.view;

import homecad.controller.AddRoomListener;
import homecad.controller.InitialiseHouseListener;
import homecad.controller.RemoveRoomListener;
import homecad.controller.SelectStoreyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ToolView extends JPanel {
   //components
   private JSlider zoom = new JSlider(50,200,100);
   private JButton initialiseHouse = new JButton("Initialise New House");
   private JButton addRoom = new JButton("Add New Room");
   private JButton removeRoom = new JButton("Remove Room");
   private JComboBox selectStorey = new JComboBox();

//Local frame instance
   private AppFrame Frame;
   
   public ToolView(AppFrame frame) {
      
      Frame =  frame;
      
      add(new JLabel("Zoom"));
      //create Sliding bar to control zoom
      zoom.setMajorTickSpacing(50);
      zoom.setPaintTicks(true);
      zoom.setPaintLabels(true);
      zoom.setSnapToTicks(true);
      add(zoom);
      zoom.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent event) {
             Frame.getDisplayView().DrawDisplay();
         }
      });
      
      //button & listener - Initialise new House
      add(initialiseHouse);
      InitialiseHouseListener initialiseHouseListener = new InitialiseHouseListener(Frame);
      initialiseHouse.addActionListener(initialiseHouseListener);

      //button & listener - Add a new Room
      add(addRoom);
      AddRoomListener addRoomListener = new AddRoomListener(Frame);
      addRoom.addActionListener(addRoomListener);
      
      //button & listener - Remove a room
      add(removeRoom);
      RemoveRoomListener removeRoomListener = new RemoveRoomListener(Frame);
      removeRoom.addActionListener(removeRoomListener);
      
      //create Storey selection from model information
      setStorey();

      add(new JLabel("Storey"));
      add(selectStorey);
      //listener to redraw display on changing storey
      SelectStoreyListener selectStoreyListener = new SelectStoreyListener(Frame);
      selectStorey.addActionListener(selectStoreyListener);
           
   }
   
   public void setStorey () {
      if (Frame.getModel() != null) {
         int storeyMax = Frame.getModel().getNumberOfStories();
         if (storeyMax == 0) selectStorey.removeAllItems();
         if (storeyMax > selectStorey.getItemCount()) selectStorey.addItem(storeyMax);
      }
   }
   
   /** getters **/
   public AppFrame getFrame() {
      return Frame;
   }

   public int getStorey() {
      //zero indexed, add 1 to return true storey
      return selectStorey.getSelectedIndex()+1;
   }

   public int getZoom() {
      //zero indexed, add 1 to return true storey
      return zoom.getValue();
   }
   
   public JSlider getZoomSlider() {
      return zoom;
   }
   /*******************/
  
}
