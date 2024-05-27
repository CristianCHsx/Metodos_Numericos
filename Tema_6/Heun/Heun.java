package Tema_6.Heun;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Heun {
    
    public static double edo(double x, double y){
        return 0.4*x*y;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        DecimalFormat de = new DecimalFormat("#.00000");
        
        
        double x0=0,xL,y0=0,xf=0,h=0,yn,x=0,n=0,ynL;

        System.out.print("Ingresa el valor de x inferior: ");
        x0 = sc.nextDouble();
        System.out.print("Ingresa el valor de y: ");
        y0 = sc.nextDouble();
        System.out.print("Ingresa el valor de x final: ");
        xf = sc.nextDouble();
        System.out.print("Ingresa la cantidad de pasos: ");
        n = sc.nextDouble();
        xL=x0;
        h=(xf-x0)/n;

        do{
            yn=y0+(h*edo(x0, y0));
            System.out.println("yn "+yn);
            xL+=h;
            System.out.println("xi+1: "+xL);
            ynL=y0+((h/2)*(edo(x0, y0)+edo(xL, yn)));
            System.out.println("yn+1* : "+ ynL);
            x0=xL;
            y0=ynL;
            x+=1;
            System.out.println("------------");
        }while(x!=n);

        System.out.println("\nEn la iteracion "+x+"--"+de.format(x0)+"[El resultado es: "+ de.format(y0));
    }
}
