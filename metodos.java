//@author Jonathan Avalos

package ejercicioioet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class metodos {
    
    String nombre="",lectura,parte2,dia,hora1,hora2;
    String [] partes,horas;
    int horast=0,totalm=0,totaln=0,totalt=0,totalfm=0,totalfn=0,totalft=0,pago=0,ihora1=0,ihora2=0;
    
    public String lectura (){
        File archivo = new File ("A:\\Jonathan\\Trabajo\\ioet\\datos.txt");      
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            lectura= entrada.readLine();
            while (lectura != null) {
                System.out.println(lectura);
                partes = lectura.split("=");
                nombre=partes[0];
                parte2=partes[1];                
                horas = parte2.split(",");
                lectura= entrada.readLine();
                int pa=metodos.this.total(dia,horas);
                System.out.println("The amount to pay "+nombre+" is: "+pa+" USD");
                horast=0;totalm=0;totaln=0;totalt=0;totalfm=0;totalfn=0;totalft=0;pago=0;ihora1=0;ihora2=0;
            } 
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return "";
    }    
    
    
    public int total (String dia,String [] horas){
        int va=0,va1=0;
        for (int i=0;i<horas.length;i++) {
            dia=horas[i].substring(0,2);
            hora1=horas[i].substring(2,4);
            hora2=horas[i].substring(8,10);
            ihora1=Integer.parseInt(hora1);
            ihora2=Integer.parseInt(hora2);
            va=metodos.this.valor(dia, ihora1, ihora2);
            va1=metodos.this.valor1(dia, ihora1, ihora2);
        }
        pago=va+va1;
        return pago;
    }
    
    public int valor (String dia,int ihora1,int ihora2){
        if (dia.equals("MO")||dia.equals("TU")||dia.equals("WE")||dia.equals("TH")||dia.equals("FR")) {
                if(ihora1>=00 && ihora2<=9){ 
                    horast=ihora2-ihora1;
                    totaln+=horast*25;
                }else if(ihora1>=9 && ihora2<=18){
                    horast=ihora2-ihora1;
                    totalm+=horast*15;
                }else if(ihora1>=18 && ihora2<=24){
                    horast=ihora2-ihora1;
                    totalt+=horast*20;
                }  
            }
        int re=totaln+totalm+totalt;
        return re;    
    }
    
    public int valor1 (String dia,int ihora1,int ihora2){
        if(dia.equals("SA")||dia.equals("SU")){
            if(ihora1>=00 && ihora2<=9){
                horast=ihora2-ihora1;
                totalfn+=horast*30;
                }else if(ihora1>=9 && ihora2<=18){
                    horast=ihora2-ihora1;
                    totalfm+=horast*20;
                }else if(ihora1>=18 && ihora2<=24){
                    horast=ihora2-ihora1;
                    totalft+=horast*25;
                }
            }  
        int re=totalfn+totalfm+totalft;
        return re;    
    }
    
}
