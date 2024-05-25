package Tema_6.Euler;
import java.util.Scanner;


public class Me_Euler{

    public static float edo(float x, float y){
        return (float)y-x;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        float x=0,xn,yn,xparad,h;

        System.out.print("Ingresa el valor de x: ");
        xn = sc.nextFloat();
        System.out.print("Ingresa el valor de y: ");
        yn = sc.nextFloat();
        System.out.print("Ingresa el valor de x final: ");
        xparad = sc.nextFloat();
        System.out.print("Ingresa el numero de pasos (h): ");
        h = sc.nextFloat();
    
        do{
            x+=1;
            xn+=h;
            System.out.println(x+"<->"+xn);
            yn=yn+(h*edo(xn,yn));
            System.out.println(x+"<->"+yn);

        }while(xn!=xparad);
        System.out.println("El resultado de la ecuacion diferencial ordinaria es: "+yn);
        
    }
}