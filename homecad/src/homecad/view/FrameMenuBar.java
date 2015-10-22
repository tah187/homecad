package homecad.view;

import homecad.controller.NewActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

//import mvcmenu.controller.NewActionListener;

public class FrameMenuBar extends JMenuBar
{
   private JMenu fileMenu;
   private JMenuItem newItem;
   private JMenuItem addRoom;
   private JMenuItem removeRoom;
   private JMenuItem exitItem;
   private JMenu viewMenu;
   private JMenuItem zoom50;
   private JMenuItem zoom100;
   private JMenuItem zoom150;
   private JMenuItem zoom200;
   private JMenu helpMenu;
   private JMenuItem instructions;
   private JMenuItem about;
   
   private AppFrame Frame;
   
   public FrameMenuBar(AppFrame frame)
   {
      Frame = frame;
      
      //Create the File menu
      fileMenu = new JMenu("File");

      //Shortcut ALT-F
      fileMenu.setMnemonic(KeyEvent.VK_F);
      this.add(fileMenu);
      
      //Create New House Instance
      newItem = new JMenuItem("New House", KeyEvent.VK_N);
      newItem.addActionListener(new NewActionListener(frame));
      newItem.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
      newItem.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            new InitialiseHouseFrame(Frame);    
         }
      });    

      //Add a Rooom
      addRoom = new JMenuItem("Add Room", KeyEvent.VK_A);
      addRoom.addActionListener(new NewActionListener(frame));
      addRoom.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
      addRoom.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            new AddRoomFrame(Frame);    
         }
      });      

      //Remove a Room
      removeRoom = new JMenuItem("Remove a Room", KeyEvent.VK_R);
      removeRoom.addActionListener(new NewActionListener(frame));
      removeRoom.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
      removeRoom.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            new RemoveRoomFrame(Frame);    
         }
      });      

      //Exit the program
      exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
      exitItem.setAccelerator
      (KeyStroke.getKeyStroke('X', InputEvent.ALT_MASK));
      exitItem.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            int reply = JOptionPane.showConfirmDialog(Frame,
                  "Are you sure you want to Exit?", "Exit Program", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) System.exit(0);
         }
      });


      fileMenu.add(newItem);
      fileMenu.addSeparator();
      fileMenu.add(addRoom);
      fileMenu.add(removeRoom);
      fileMenu.addSeparator();
      fileMenu.add(exitItem);

      //Create the View menu
      viewMenu = new JMenu("View");

      //Shortcut ALT-V
      viewMenu.setMnemonic(KeyEvent.VK_V);
      this.add(viewMenu);

      //Create Zoom menu items
      zoom50 = new JMenuItem("Zoom 50%", KeyEvent.VK_1);
      zoom50.addActionListener(new NewActionListener(frame));
      zoom50.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
      zoom50.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            Frame.getToolView().getZoomSlider().setValue(50);
         }
      });    

      zoom100 = new JMenuItem("Zoom 100%", KeyEvent.VK_2);
      zoom100.addActionListener(new NewActionListener(frame));
      zoom100.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
      zoom100.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            Frame.getToolView().getZoomSlider().setValue(100);
         }
      });    

      zoom150 = new JMenuItem("Zoom 150%", KeyEvent.VK_3);
      zoom150.addActionListener(new NewActionListener(frame));
      zoom150.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));
      zoom150.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            Frame.getToolView().getZoomSlider().setValue(150);
         }
      });    

      zoom200 = new JMenuItem("Zoom 200%", KeyEvent.VK_4);
      zoom200.addActionListener(new NewActionListener(frame));
      zoom200.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK));
      zoom200.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            Frame.getToolView().getZoomSlider().setValue(200);
         }
      });    

      viewMenu.add(zoom50);
      viewMenu.add(zoom100);
      viewMenu.add(zoom150);
      viewMenu.add(zoom200);
      
      
      helpMenu = new JMenu("Help");

      //Shortcut ALT-H
      helpMenu.setMnemonic(KeyEvent.VK_H);
      
      
      about = new JMenuItem("About", KeyEvent.VK_Z);
      about.addActionListener(new NewActionListener(frame));
      about.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
      about.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            JFrame panel = new JFrame();
            panel.setVisible(true);
            panel.setSize(400, 200);
            panel.setLocation(100, 175);
            panel.setTitle("About HomeCAD");
            JLabel textAbout= new JLabel("s3294287 Tim Hayward assignment 2 - HomeCAD");
            textAbout.setVerticalAlignment(JLabel.TOP);
            textAbout.setHorizontalAlignment(JLabel.LEFT);
            panel.add(textAbout);
         }
      }); 
      
      instructions = new JMenuItem("Instructions", KeyEvent.VK_I);
      instructions.addActionListener(new NewActionListener(frame));
      instructions.setAccelerator
         (KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
      instructions.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            JFrame instFrame = new JFrame();
            instFrame.setVisible(true);
            instFrame.setSize(400, 200);
            instFrame.setLocation(100, 175);
            instFrame.setTitle("Instructions");
            JLabel instruction = new JLabel("<html>Initialise a New House to start<br>"+
            		"Add a room to create a grid<br>"+
            		"Click on an empty to panel to add a room<br>"+
            		"Alt-Click on a room to remove it.</html>"
            );
            instruction.setVerticalAlignment(JLabel.TOP);
            instruction.setHorizontalAlignment(JLabel.LEFT);
            instFrame.add(instruction);
            }
      }); 
      
      this.add(helpMenu);
      helpMenu.add(instructions);
      helpMenu.addSeparator();
      helpMenu.add(about);
   }
   
}

