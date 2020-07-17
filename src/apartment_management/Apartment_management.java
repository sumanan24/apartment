/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartment_management;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Admin
 */
public class Apartment_management {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    }   catch (ClassNotFoundException ex) { 
            Logger.getLogger(Apartment_management.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Apartment_management.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Apartment_management.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Apartment_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
//        loding
        loading ld=new loading();
        ld.setVisible(true);
        try{
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(40);
                ld.jLabel1.setText(Integer.toString(i)+"%");
               // ld.jProgressBar1.setValue(i);
               if(i==100)
               {
                  loginpannel l=new loginpannel();
                  l.setVisible(true); 
                  ld.setVisible(false);
                  
               }
                
            }
            
        }
        catch(InterruptedException e)
        {
            
    }
//      new salary().setVisible(true);
    }
    
}
