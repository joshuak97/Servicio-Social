package Principal;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public final class MDIprincipal extends JFrame{
    
    JMenuBar barra;
    JMenu alumnos,reportes,documentacion,administracion,opciones,salir;
    JMenuItem nuevoAlumno,consultaAlumnos,entregaReportes,documentacionS,ventas,nuevoReporte,liberacion,carreras,dependencias,cerrarSesion,
    acercaDe,ayuda,salir2;
    MainDesktopPane panel;
    
    
    public MDIprincipal(){
        setTitle("MDI Social Service System");
        setSize(980,735);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        iniciar();
        
    }
    
    public void iniciar(){       
        //Inicializamos las opciones principales del menu
        barra= new JMenuBar();
        alumnos=new JMenu("Alumnos");
        reportes=new JMenu("Reportes");
        documentacion=new JMenu("Documentacion");
        administracion=new JMenu("Administracion");
        opciones=new JMenu("Opciones");
        salir=new JMenu("Salir");
        //Inicializamos las opciones que se desplegaran al seleccionar alguna opcion principal
        nuevoAlumno=new JMenuItem("Nuevo Alumno");
        consultaAlumnos=new JMenuItem("Administrar Alumnos");
        documentacionS=new JMenuItem("Documentacion para el Servicio Social");
        ventas=new JMenuItem("Ventas");
        entregaReportes=new JMenuItem("Reportes entregados");
        nuevoReporte=new JMenuItem("Gestion de reportes");
        liberacion=new JMenuItem("Liberacion del Servicio Social");
        carreras=new JMenuItem("Administrar Carreras");
        dependencias=new JMenuItem("Administrar Dependencias");
        acercaDe=new JMenuItem("Acerca De");
        ayuda=new JMenuItem("Ayuda");
        cerrarSesion=new JMenuItem("Cerrar Sesión");
        salir2=new JMenuItem("Salir");
        //Añadiremos los JMenuItem a sus respectivos JMenu:
        //alumnos.add(nuevoAlumno);
        alumnos.add(consultaAlumnos);
        
        reportes.add(nuevoReporte);
       
        
        documentacion.add(documentacionS);
        
        administracion.add(liberacion);
        administracion.add(carreras);
        administracion.add(dependencias);
        
        opciones.add(acercaDe);
        opciones.add(ayuda);
        opciones.add(cerrarSesion);
        
        barra.add(alumnos);
        barra.add(reportes);
        barra.add(documentacion);
        barra.add(administracion);
        barra.add(opciones);
        barra.add(salir);
        setJMenuBar(barra);
        
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/logo3.png")).getImage();
        setIconImage(icon);
              
     //Colocamos los iconos a cada opcion del sistema           
     ImageIcon iconReg=new ImageIcon(getClass().getResource("/Imagenes/alumno.png"));
     alumnos.setIcon(iconReg);
     ImageIcon iconOpciones=new ImageIcon(getClass().getResource("/Imagenes/opciones.png")); 
     ImageIcon iconConsultas=new ImageIcon(getClass().getResource("/Imagenes/consultas.png"));
     ImageIcon iconAdministracion=new ImageIcon(getClass().getResource("/Imagenes/admin.png"));
     ImageIcon iconAutor=new ImageIcon(getClass().getResource("/Imagenes/registro.png"));
     ImageIcon iconNuevoAlu=new ImageIcon(getClass().getResource("/Imagenes/nuevoAlu.png"));
     ImageIcon iconConAlumnos=new ImageIcon(getClass().getResource("/Imagenes/consultaAlu.png"));
     ImageIcon iconVentas=new ImageIcon(getClass().getResource("/Imagenes/ventas.png"));
     ImageIcon iconReportes=new ImageIcon(getClass().getResource("/Imagenes/documento.png"));
     ImageIcon iconLiberacion=new ImageIcon(getClass().getResource("/Imagenes/liberacion.png"));
     ImageIcon iconCarreras=new ImageIcon(getClass().getResource("/Imagenes/carreras.png"));
     ImageIcon iconDependencias=new ImageIcon(getClass().getResource("/Imagenes/dependencias.png"));
     ImageIcon iconSalir=new ImageIcon(getClass().getResource("/Imagenes/salir.png"));
     ImageIcon iconDocumento=new ImageIcon(getClass().getResource("/Imagenes/escritura.png"));
     ImageIcon iconAcercaDe=new ImageIcon(getClass().getResource("/Imagenes/acercaD.png"));
     ImageIcon iconAyuda=new ImageIcon(getClass().getResource("/Imagenes/info.png"));
     ImageIcon iconCerrarSesion=new ImageIcon(getClass().getResource("/Imagenes/off.png"));  
     ImageIcon iconSalir2=new ImageIcon(getClass().getResource("/Imagenes/salir.png"));
     
     opciones.setIcon(iconOpciones);
     documentacion.setIcon(iconConsultas);
     documentacionS.setIcon(iconConsultas);
     administracion.setIcon(iconAdministracion);
     liberacion.setIcon(iconLiberacion);
     carreras.setIcon(iconCarreras);
     dependencias.setIcon(iconDependencias);
     salir.setIcon(iconSalir);
     reportes.setIcon(iconAutor);
     nuevoAlumno.setIcon(iconNuevoAlu);
     consultaAlumnos.setIcon(iconConAlumnos);
     ventas.setIcon(iconVentas);
     entregaReportes.setIcon(iconReportes);
     nuevoReporte.setIcon(iconDocumento);
     acercaDe.setIcon(iconAcercaDe);
     ayuda.setIcon(iconAyuda);
     cerrarSesion.setIcon(iconCerrarSesion);
     salir2.setIcon(iconSalir2);
     panel=new MainDesktopPane();
       getContentPane().add(panel); 
     salir.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
               int i=JOptionPane.showConfirmDialog(null,"Desea Salir de la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION);
        
        if(i==JOptionPane.YES_OPTION){
            
        JOptionPane.showMessageDialog(null,"Que pase bonito día!","Gracias por utlizar Social Service System",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
        }

            }
        
        });
     
     consultaAlumnos.addActionListener((ActionEvent e) -> {
         FrmNuevoAlumno us=new FrmNuevoAlumno();
   
         panel.add(us);
         Dimension desktopSize = panel.getSize();
        Dimension FrameSize = us.getSize();
        us.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        us.show();
        });
     carreras.addActionListener((ActionEvent e) -> {
         FrmGestionCarreras us = new FrmGestionCarreras();
         
         panel.add(us);
         Dimension desktopSize = panel.getSize();
        Dimension FrameSize = us.getSize();
        us.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        us.show();
        });
     nuevoReporte.addActionListener((ActionEvent e) -> {
         FrmNuevorReporte us = new FrmNuevorReporte();
         
         panel.add(us);
         Dimension desktopSize = panel.getSize();
        Dimension FrameSize = us.getSize();
        us.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        us.show();
        });
      dependencias.addActionListener((ActionEvent e) -> {
         FrmDependencias us = new FrmDependencias();
         
         panel.add(us);
        Dimension desktopSize = panel.getSize();
        Dimension FrameSize = us.getSize();
        us.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        us.show();
        });
       acercaDe.addActionListener((ActionEvent e) -> {
         AcercaDe us = new AcercaDe();
         
        panel.add(us);
        Dimension desktopSize = panel.getSize();
        Dimension FrameSize = us.getSize();
        us.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        us.show();
        });
       documentacionS.addActionListener((ActionEvent e) -> {
        FrmDocumentos us = new FrmDocumentos();
         
        panel.add(us);
        Dimension desktopSize = panel.getSize();
        Dimension FrameSize = us.getSize();
        us.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        us.show();
        });
       cerrarSesion.addActionListener(this::cerrarSesion);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
     public void salir(){

         System.exit(0);
}
    

 public void cerrarSesion(ActionEvent e){
    
       int i=JOptionPane.showConfirmDialog(null,"Desea cerrar sesión?","Confirmación",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){            
       new frmLogin().setVisible(true);
        this.dispose();
        }

        
    }  
    
}
