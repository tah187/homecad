package homecad.view;

import javax.swing.JFrame;

import homecad.controller.AppFrameListener;
import homecad.model.facade.HomeCADengine;
import java.awt.BorderLayout;
import java.awt.Container;


public class AppFrame extends JFrame
{
   // the Main Frame Container
   private Container container;

   // containers for laying out the components on the Frame
   private ToolView toolView;
   private DisplayView displayView;
   private StatusView statusView;
   private FrameMenuBar menuBar;
   
   //HomeCAD Engine
   private HomeCADengine model;

   public AppFrame() {
      
      //set exit behaviour
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.addWindowListener(new AppFrameListener(this));   

      container = this.getContentPane();
      container.setLayout(new BorderLayout());
      
      // initialise components
      toolView = new ToolView(this);
      displayView = new DisplayView(this);
      statusView = new StatusView(this,"Status");

      // Menu bar
      menuBar = new FrameMenuBar(this);
      setJMenuBar(menuBar);

      // Render the components onto the frame
      displayComponents();

      // Set initial size and location 
      setSize(800, 600);
      setLocation(100, 175);
      setVisible(true);    
   }

   private void displayComponents() {
      container.add(toolView, BorderLayout.NORTH);
      container.add(displayView, BorderLayout.CENTER);
      container.add(statusView, BorderLayout.SOUTH);      
   }

   /** getters and setters **/
   public ToolView getToolView() {
      return toolView;
   }
   
   public DisplayView getDisplayView() {
      return displayView;
   }  
   
   public StatusView getStatusView() {
      return statusView;
   }
   
   public FrameMenuBar getFrameMenuBar() {
      return menuBar;
   }
   
   public HomeCADengine getModel() {
      return model;
   }   

   public void setModel(HomeCADengine Model) {
      model = Model;
   }   
   
   /*******************/

}