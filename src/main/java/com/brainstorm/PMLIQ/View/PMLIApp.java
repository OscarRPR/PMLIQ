/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainstorm.PMLIQ.View;

import com.brainstorm.PMLIQ.Control.AdministrarEquipos;
import com.brainstorm.PMLIQ.Control.AdministrarFabricantes;
import com.brainstorm.PMLIQ.Control.AdministrarItems;
import com.brainstorm.PMLIQ.Control.AdministrarNotificaciones;
import com.brainstorm.PMLIQ.Model.Sistema;
import com.brainstorm.PMLIQ.View.ventana.MainWindow;
import com.brainstorm.PMLIQ.View.ventana.WindowEventHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

/**
 *
 * @author Silex RPR
 */
public class PMLIApp {

    private MainWindow mainWindow;
    private Sistema sistema;
    
    private AdministrarEquipos admEquipos;
    private AdministrarFabricantes admFabricantes;
    private AdministrarItems admItems;
    private AdministrarNotificaciones admNotificaciones;
    
    private PMLIApp()
    {
        admEquipos = new AdministrarEquipos();
        admFabricantes = new AdministrarFabricantes();
        admItems = new AdministrarItems();
        admNotificaciones = new AdministrarNotificaciones();
        
        sistema = new Sistema();
        sistema.inicializaEquipos();
        sistema.inicializaFabricantes();
        sistema.inicializaInventario();
    }
    
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
            
            mainWindow.addWindowListener(new WindowEventHandler());
    }
    
    public synchronized static PMLIApp getInstance() {
		while (m_this == null) {
			m_this = new PMLIApp();
		}
		return m_this;
    }

    public Sistema getSistema() {
        return sistema;
    }
    
    public MainWindow getMainWindow()
    {
        return mainWindow;
    }

    public AdministrarEquipos getAdmEquipos() {
        return admEquipos;
    }

    public AdministrarFabricantes getAdmFabricantes() {
        return admFabricantes;
    }

    public void setAdmFabricantes(AdministrarFabricantes admFabricantes) {
        this.admFabricantes = admFabricantes;
    }

    public AdministrarItems getAdmItems() {
        return admItems;
    }

    public void setAdmItems(AdministrarItems admItems) {
        this.admItems = admItems;
    }

    public AdministrarNotificaciones getAdmNotificaciones() {
        return admNotificaciones;
    }

    public void setAdmNotificaciones(AdministrarNotificaciones admNotificaciones) {
        this.admNotificaciones = admNotificaciones;
    }

    private static PMLIApp m_this;
}
