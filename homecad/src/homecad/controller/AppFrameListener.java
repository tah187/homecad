package homecad.controller;

import homecad.view.AppFrame;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class AppFrameListener extends WindowAdapter implements ActionListener {
	
	private AppFrame frame;

	public AppFrameListener(AppFrame frame) {
		this.frame = frame;
	}	
		
	@Override
	public void windowClosing(WindowEvent e) {
		confirmExit();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		confirmExit();
	}
	
	public void confirmExit() {
      int reply = JOptionPane.showConfirmDialog(frame,
            "Are you sure you want to Exit?", "Exit Program", JOptionPane.YES_NO_OPTION);
      if (reply == JOptionPane.YES_OPTION) System.exit(0);
	}	
}
