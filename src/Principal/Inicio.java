/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.File;
import javax.swing.JOptionPane;

public class Inicio {
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info:javax.swing.UIManager.getInstalledLookAndFeels()) {
              
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level
                    .SEVERE, null, ex);
            
        } 
           
        File f=new File("C:\\SocialServiceSystem\\ArchivosSS"); 
       if(f.exists()){
       JOptionPane.showMessageDialog(null,"Ficheros en Orden","Verificación de Ficheros",JOptionPane.INFORMATION_MESSAGE);
       }else{
       f.mkdirs();
       }
       frmLogin o=new frmLogin();
       o.setVisible(true);
       }
    }
    

