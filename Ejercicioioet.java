//@author Jonathan Avalos
package ejercicioioet;

import java.io.*;

public class Ejercicioioet {

    public static void main(String[] args) {
        File archivo = new File ("A:\\Jonathan\\Trabajo\\ioet\\datos.txt");
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura;
            lectura= entrada.readLine();
            while (lectura != null) {
                String [] partes = lectura.split("=");
                String parte1=partes[0];
                String parte2=partes[1];
                System.out.println(lectura);
                System.out.println(parte1);                
                String [] horas = parte2.split(",");
                for (int i=0;i<horas.length;i++) {
                    String hor=horas[i];
                    String dia=horas[i].substring(0,2);
                    String hora1=horas[i].substring(2,4);
                    String hora2=horas[i].substring(8,10);
                    
                    System.out.println(hor);
                    System.out.println(dia); 
                    
                    System.out.println(hora1+"/"+hora2);
                    int horast=Integer.parseInt(hora2)-Integer.parseInt(hora1);
                    System.out.println(horast);
                    
                }                                                  
                lectura= entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();;
        } 
    
    }
    
}
