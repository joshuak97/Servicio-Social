package Principal;
import Datos.DLogin;
import java.awt.Image;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public final class frmLogin extends JFrame implements ActionListener{
    
    
    JTextField txt1,txt2;
    JLabel lbl1,lbl2,imagen;
    JButton acceder,cancelar;
    JPasswordField logi;
    JPanel fondo;
    
    int cont=1;
    
    
    public frmLogin(){
        
        setTitle("Departamento de Servicio Social Autentificacion de Usuarios...");
        setSize(550,300);
        setDefaultCloseOperation(3);
        setLayout(null);
        setLocationRelativeTo(this);
        iniciar();
    }
    
    public void iniciar(){
        lbl1=new JLabel("Usuario:");
        txt1=new JTextField();
        lbl2=new JLabel("Contraseña");
        logi=new JPasswordField();
        logi.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwKeyReleased(evt);
            }
           
        });
        acceder=new JButton("Acceder");
        cancelar=new JButton("Cancelar");
        imagen=new JLabel();
        fondo=new JPanel(); 
        add(fondo);
        fondo.add(lbl1);
        fondo.add(lbl2);
        fondo.add(txt1);
        fondo.add(logi);
        fondo.add(acceder);
        fondo.add(cancelar);
        fondo.setLayout(null);
        fondo.setBounds(0,0,550,300);
        lbl1.setBounds(250,50,100,30);
        txt1.setBounds(350, 50, 140, 30);
        lbl2.setBounds(250,120,100,30);
        logi.setBounds(350,120,140,30);
        acceder.setBounds(250,170,100,30);
        cancelar.setBounds(390,170,100,30);
        fondo.setBackground(new java.awt.Color(255,153,0));
        ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/logo2.png"));
        imagen.setBounds(30,30,178,178);
        imagen.setIcon(img);
        fondo.add(imagen);
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logo3.png")).getImage();
        setIconImage(icon);
        acceder.addActionListener(this);
        cancelar.addActionListener(this);
        


        
        
        
        
    }
    
    public void validarCampos(){
    
    if(txt1.getText().equals("")){
    
        JOptionPane.showMessageDialog(this,"Introduzca una Cuenta de Usuario Valida");
    
    }
    
    mostrar();     
    }
     private void passwKeyReleased(java.awt.event.KeyEvent evt) {                                  
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
    
mostrar();         
        }
    }             
    public void limpiar(){
        
        txt1.setText("");
        logi.setText("");
    
    }
    public void conteo(){
        if(cont<3){
        
            cont++;
        }else{
        
            JOptionPane.showMessageDialog(null,"Usted a exedido el numero de intentos","Advertencia",JOptionPane.WARNING_MESSAGE);
            
        }        
        
    
    }
    public void mostrar(){
        DLogin du1=new DLogin();
        String usuario=txt1.getText();
        String clave=String.valueOf(logi.getPassword());
        if(du1.validarLogin(usuario, clave)==1){       
        this.dispose();
        
        MDIprincipal vn=new MDIprincipal();
        vn.setVisible(true);
        
        }
        else{
        JOptionPane.showMessageDialog(this,"Usuario o Contraseña incorrecta, intente de nuevo por favor¡","Error",JOptionPane.ERROR_MESSAGE);
        txt1.setText("");
        logi.setText("");
        txt1.requestFocusInWindow();
        }      
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
          if(e.getSource()==acceder){
            
            
          
           
           validarCampos(); 
           
           
           

            }
        
        
        if(e.getSource()==cancelar){
            
            this.dispose();
        }
        
    }
    
        
}
