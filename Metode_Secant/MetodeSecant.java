package Metode_Secant;

import java.util.Scanner;

public class MetodeSecant {
    static Scanner in = new Scanner(System.in);
    static double batasBawah, batasAtas;

    public static double fungsi(double x) {
        double y;
        // Soal 1
        y = (x * Math.exp(-x)) + Math.sin(2*x);
        // // Soal 2
        // y = Math.cos(x+1) + Math.exp(-x+2);
        // // Soal 3
        // y = Math.cos(x) - Math.sin(x);

        return y;
    }

    public static void metodeTabel(double a, double b, int n) {
        double xi1, xi2, y1, y2, h;

        // Menghitung step pembagi
        h = (b-a)/n;

        System.out.println("i \t\t    xi \t\t\t   f(xi)");
        for (int i = 0; i <= n; i++) {
            xi1 = a + i * h;
            y1 = fungsi(xi1);
            System.out.printf("%d \t\t %f \t\t %f\n", i, xi1, y1);
        }

        // Dicari nilai range yang terdapat akar persamaan
        int i = 0;
        while (i <= n) {
            xi1 = a + i * h;
            y1 = fungsi(xi1);
            xi2 = a + (i+1) * h;
            y2 = fungsi(xi2);

            if (y1 == 0) {
                batasBawah = xi1;
                System.out.printf("Akar persamaannya adalah = %f\n\n", batasBawah);
                break;
            } else if (y1 * y2 < 0) {
                if (Math.abs(y1) < Math.abs(y2)) {
                    batasBawah = xi1;
                    batasAtas = xi2;
                    System.out.printf("Range yang terdapat akar terletak pada [%f, %f]\n\n", batasBawah, batasAtas);
                    break;
                } else {
                    batasBawah = xi1;
                    batasAtas = xi2;
                    System.out.printf("Range yang terdapat akar terletak pada [%f, %f]\n\n", batasBawah, batasAtas);
                    break;
                }
            }    
            i++;
        }
    }
    public static void main(String[] args) {
        double e, y0, y1, y2 = 0;
        double x0, x1, x2 = 0;
        int n;

        System.out.print("Nilai batas bawah = ");
        x0 = in.nextDouble();
        System.out.print("Nilai batas atas = ");
        x1 = in.nextDouble();
        System.out.print("Iterasi = ");
        n = in.nextInt();
        System.out.print("Nilai galat error = ");
        e = in.nextDouble();
        in.close();

        // Dipersempit range dengan menggunakan metode tabel
        System.out.println("=======================METODE TABEL=======================");
        metodeTabel(x0, x1, n);

        // Memperbarui batas bawah dan batas atas yang diperoleh dari metode tabel
        x0 = batasBawah;
        x1 = batasAtas;

        // Metode Secant
        System.out.println("============================================================METODE SECANT============================================================");
        System.out.println("Iterasi\t\t\t    x0\t\t\t\t   x1\t\t\t\t   x2\t\t\t\t  f(x2)");
        int i = 0;
        while (Math.abs(fungsi(x1) - fungsi(x0)) >= e && i <= n) {
            y0 = fungsi(x0);
            y1 = fungsi(x1);
            // Rumus yang digunakan pada metode secant
            x2 = x1 - y1 * ((x1 - x0) / (y1 - y0));
            y2 = fungsi(x2);

            System.out.printf("%d\t\t\t%f\t\t\t%f\t\t\t%f\t\t\t%.10f\n", i, x0, x1, x2, y2);
            // Diperbarui nilai untuk pencarian berikutnya
            x0 = x1;
            x1 = x2;
            
            i++;
        }

        System.out.printf("Akar persamaannya adalah = %f dengan f(x) = %.10f", x2, y2);

    }
}