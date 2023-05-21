package Probe;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Correlation {
    public static void main(String [] args){
        float b[] = new float[20];
        float a[] = new float[20];
        float Xa,Ya,b1,b0,Rxy,R2,Yk,Xsum,Ysum,xy,x2,y2,Xk;
        int i;
        Xsum = Ysum = xy = x2 = y2 = 0;
        Scanner sc = new Scanner(System.in);
        for (i = 0;i < 10;i ++){
            a[i] = sc.nextFloat();
            Xsum += a[i];
        }
        for (i = 0;i < 10;i ++){
            b[i] = sc.nextFloat();
            Ysum += b[i];
        }
        System.out.println("Xk 等于：");
        Xk = sc.nextFloat();
        Xa = Xsum / 10;
        Ya = Ysum / 10;
        for (i = 0;i < 10;i ++){
            xy = a[i] * b[i] + xy;
            x2 = a[i] * a[i] + x2;
            y2 = b[i] * b[i] + y2;
        }
        b1 = (xy - 10 * Xa * Ya)/(x2 - 10 * Xa * Xa);
        b0 = Ya - b1 * Xa;
        Rxy = (float) ((10 * xy - Xsum * Ysum)/ sqrt((10 * x2 - Xsum * Xsum) * (10 * y2 - Ysum * Ysum)));
        R2 = Rxy * Rxy;
        Yk = b0 + b1 * Xk;
        System.out.println("β0 = "+ b0 +"β1 = "+ b1 +"Rx.y ="+ Rxy +"r² = "+ R2 +"yk = "+ Yk);
    }
}