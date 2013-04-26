/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View;

import com.brainstorm.PMLIQ.View.ventana.MainWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

/**
 *
 * @author Silex RPR
 */
public class PMLIApp {

    private JFrame mainWindow;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
  	JFrame.setDefaultLookAndFeelDecorated(true);
	//Aplicamos un skin a nuestra ventana, en este caso SaharaSkin

	Runnable doWorkRunnable = new Runnable() {

                        @Override
			public void run() {
                            try {  
                                PMLIApp.getInstance().run();
                            } catch (UnsupportedLookAndFeelException ex) {
                                Logger.getLogger(PMLIApp.class.getName()).log(Level.SEVERE, null, ex);
                            }

			}
		};  
        SwingUtilities.invokeLater(doWorkRunnable);

    }
    
    public void run() throws UnsupportedLookAndFeelException {
  
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.SaharaSkin");
            
            mainWindow = new MainWindow();
            mainWindow.setTitle("PMLIQ");
            mainWindow.setVisible(true);
                
            mainWindow.setLocationRelativeTo(null);
    }
    
    public synchronized static PMLIApp getInstance() {
		while (m_this == null) {
			m_this = new PMLIApp();
		}
		return m_this;
    }
    
    public JFrame getMainWindow()
    {
        return mainWindow;
    }
    
    private static PMLIApp m_this;
}
