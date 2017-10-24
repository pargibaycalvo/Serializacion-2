/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Serializacion2 {

    /**
     * @param args the command line arguments
     */
    
    static String[]cod={"p1","p2","p3"};
    static String[]des={"parafusos","cravos","tachas"};
    static Double[]prezo={3.0,4.0,5.0};
    
    static File directorio = new File("/home/oracle/NetBeansProjects/serializacion2/archivos");
    static File archivo = new File("/home/oracle/NetBeansProjects/serializacion2/serial.txt");
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        product obj1 = new product(cod[0],des[0],prezo[0]);
        product obj2 = new product(cod[1],des[1],prezo[1]);
        product obj3 = new product(cod[2],des[2],prezo[2]);
        
        carpeta(directorio);
        archivo(archivo);
        escribir(obj1,obj2,obj3,archivo);
        leer(archivo);
        
        
    }
    
    static void carpeta(File directorio){

        if(directorio.exists())
            System.out.println("Directorio existente "+directorio.getPath());
        else
            directorio.mkdir();
    }
    
    static void archivo(File archivo) throws IOException{

        if(archivo.exists())
            System.out.println("Archivo de texto existente "+archivo.getPath());
        else
            archivo.createNewFile();
    }
    
    static void escribir(product p1,product p2,product p3, File archivo){
        try {
              ObjectOutputStream esc = new ObjectOutputStream(new FileOutputStream(archivo));
              esc.writeObject(p1);
              esc.writeObject(p2);
              esc.writeObject(p3);
              esc.writeObject(null);
              esc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void leer(File archivo){
        try {
            ObjectInputStream ler = new ObjectInputStream(new FileInputStream(archivo));
            product aux = (product) ler.readObject();
            while(aux!=null){
                System.out.println(aux.toString());
                aux = (product) ler.readObject();  
            }  
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
    
}
