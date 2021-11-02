import java.util.Scanner;

/**
 * @author Daffa Mudhaffar
 * 2008107010013
 */


public class NewtonRhapson{
    
    public static double fungsi(double x) {
        double y;
        // Fungsi pada soal pertama
        y = (4 * Math.pow(x,3)) - (15 * Math.pow(x, 2)) + (17 * x) - 6;

        // // Fungsi pada soal kedua
        // y = Math.pow(x, 3) - (2 * (Math.pow(x, 2))) + (3 * x) - 6;
        
        // // Fungsi pada soal ketiga
        // y = Math.pow(x, 5) + (2 * Math.pow(x, 2)) - 4;

        return y;
    }

    public static double turunan(double x) {
        double y;
        // Turunan fungsi pada soal pertama
        y = (12 * Math.pow(x,2)) - (30 * x) + 17;

        // // Turunan fungsi pada soal kedua
        // y = (3 * Math.pow(x, 2)) - (4 * x) + 3;

        // // Turunan fungsi pada soal ketiga
        // y = (5 * Math.pow(x, 4)) + (4 * x);

        return y;
    }

    public static void main(String[] args){
        // nMax = iterasi maksimum, n = iterasi
        int nMax, n = 0;
        // fx = nilai f(x), gx = nilai f'(x), x0 = pendekatan awal, e = nilai galat toleransi, x1 = nilai x yang baru
        double fx = 0, gx, x0, e, x1 = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan nilai pendekatan awal: ");
        x0 = in.nextDouble();
        System.out.print("Masukkan nilai iterasi maksimum: ");
        nMax = in.nextInt();
        System.out.print("Masukkan nilai galat toleransi: ");
        e = in.nextDouble();
        in.close();
        
        

        System.out.println("Iterasi\t\t\t   x0\t\t\t\t   x1\t\t\t\t  f(x)\t\t\t\t  f'(x)");
        // Selama |f(x)| >= e dan n < nMaks maka proses akan terus berjalan
        while(Math.abs(fungsi(x0)) >= e && n < nMax) {
            // Hitung nilai f(x) dan f'(x)
            fx = fungsi(x0);
            gx = turunan(x0);
            
            // Rumus Newton Rhapson, dengan x1 adalah akar dari persamaan
            x1 = x0 - (fx/gx);

            System.out.printf("%d\t\t\t%f\t\t\t%f\t\t\t%f\t\t\t%f\n", n, x0,x1,fx,gx);
            x0 = x1;
            n++;
        } 

        System.out.print("Jadi, akar persamaannya terletak pada x = " + x1 + ", dengan nilai f(x) = " + fx);
    }
}