package Tema_6.Euler;
import java.util.Scanner;
import java.text.DecimalFormat;


public class Me_Euler{

    public static double edo(double x, double y){
        return (Math.pow(x, 2)-1)/Math.pow(y, 2);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        DecimalFormat de = new DecimalFormat("#.00000");
        
        
        double x0=0,y0=0,xf=0,h=0,yn,x=0,n=0;

        System.out.print("Ingresa el valor de x inferior: ");
        x0 = sc.nextDouble();
        System.out.print("Ingresa el valor de y: ");
        y0 = sc.nextDouble();
        System.out.print("Ingresa el valor de x final: ");
        xf = sc.nextDouble();
        System.out.print("Ingresa la cantidad de pasos: ");
        n = sc.nextDouble();

        h=(xf-x0)/n;

        do{
            System.out.println(x);
            yn=y0+(h*edo(x0, y0));
            x0+=h;
            y0=yn;
            x+=1;
        }while(x!=n);

        System.out.println("En la iteracion "+x+"--"+de.format(x0)+"[El resultado es: "+ de.format(yn));
    }
}