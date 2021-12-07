/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Login.Login;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author DIEGO
 */
public class Proyecto_Cafeteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            javax.swing.UIManager.setLookAndFeel(s);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Proyecto_Cafeteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Login().setVisible(true);
    }
    
}
