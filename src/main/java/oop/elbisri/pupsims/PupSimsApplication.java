package oop.elbisri.pupsims;

import javax.swing.SwingUtilities;

import oop.elbisri.pupsims.ui.MainFrame;

/**
 * PUP-SIMS Application Entry Point.
 * 
 * @author Rian Reyes
 *
 */
public class PupSimsApplication {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			MainFrame mainFrame = new MainFrame();
			mainFrame.setVisible(true);
		});
		
	}

}
