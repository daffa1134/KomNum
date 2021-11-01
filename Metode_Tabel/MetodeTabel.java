package Metode_Tabel;

import java.util.Scanner;

public class MetodeTabel {
    static Scanner in = new Scanner(System.in);

    public static double fungsi(double x) {
        double y;
        // Soal
        y = (Math.exp(-x)) - x;

        return y;
    }

    public static void main(String[] args) {
        double xi1, xi2, y1, y2, h;
        double a, b;
        int n;

        System.out.print("Nilai batas bawah = ");
        a = in.nextDouble();
        System.out.print("Nilai batas atas = ");
        b = in.nextDouble();
        System.out.print("Iterasi = ");
        n = in.nextInt();

        h = (b-a)/n;

        System.out.println("i \t\t    xi \t\t\t   f(xi)");
        for (int i = 0; i <= n; i++) {
            xi1 = a + i * h;
            y1 = fungsi(xi1);
            System.out.printf("%d \t\t %f \t\t %f\n", i, xi1, y1);
        }

        int i = 0;
        while (i <= n) {
            xi1 = a + i * h;
            y1 = fungsi(xi1);
            xi2 = a + (i+1) * h;
            y2 = fungsi(xi2);

            if (y1 == 0) {
                xi1 = a;
                System.out.printf("Akar persamaannya adalah = %f dengan f(x) = %f\n", xi1, y1);
                break;
            } else if (y1 * y2 < 0) {
                if (Math.abs(y1) < Math.abs(y2)) {
                    System.out.printf("Akar persamaannya adalah = %f dengan f(x) = %f\n", xi1, y1);
                    xi1 = a;
                    xi2 = b;
                    break;
                } else {
                    System.out.printf("Akar persamaannya adalah = %f dengan f(x) = %f\n", xi2, y2);
                    xi1 = a;
                    xi2 = b;
                    break;
                }
            }
            
            i++;
        }

    }
}
