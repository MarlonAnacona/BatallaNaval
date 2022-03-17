import javax.swing.*;
import java.util.ArrayList;

public class barcosRecibidos {

public boolean barcosColocados1;
public static  int barco=0;
public static  ArrayList<JButton> botonesUsados=new ArrayList<JButton>();


public barcosRecibidos(){

    }

    public void getBarcos(ArrayList enemigo){

botonesUsados=enemigo;
    }

    public int numero(int barco){
    this.barco=barco;
    return this.barco;
    }

    public int setNumero(){
    return  barco;
    }

    public boolean setcolocados(boolean barcosColocados){
       if (barcosColocados){
           barco++;
    numero(barco);
       }
        return barcosColocados1;
    }

    public boolean get(){

        return barcosColocados1;
    }
}
