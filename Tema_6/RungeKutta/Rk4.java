package Tema_6.RungeKutta;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Rk4 {

    public static double edo(double x, double y){
        return 2*x*y;
    }
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        DecimalFormat de = new DecimalFormat("#.00000");
        

        double x0,y0,xf,h,ch,ynm,k1,k2,k3,k4,x=0;

        System.out.print("Ingresa el valor de x inicial: ");
        x0=sc.nextDouble();
        System.out.print("Ingresa el valor de y: ");
        y0=sc.nextDouble();
        System.out.print("Ingresa el valor de x final: ");
        xf=sc.nextDouble();
        System.out.print("Ingresa la cantidad de pasos: ");
        ch=sc.nextDouble();
        
        h=(xf-x0)/ch;

        do{
            //System.out.println(y0);
            k1=edo(x0, y0);

            k2=edo(x0+(h/2),y0+((h/2)*k1));
            k3=edo(x0+(h/2),y0+((h/2)*k2));
            k4=edo(x0+h,(y0+(h*k3)));
            ynm=y0+(h/6)*(k1+(2*k2)+(2*k3)+k4);
            x0+=h;
            y0=ynm;
            x+=1;
        }while(x!=ch);
        System.out.println("El resultado es: "+ de.format(y0));
    }
    
}
