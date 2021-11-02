import java.util.Scanner;

/**
 * @author Daffa Mudhaffar
 * 2008107010013
 */


public class Biseksi {
    public static void main(String[] args) {
        // nMax = iterasi maks
        int nMax;
        // a = batas bawah, b = batas atas, fa = nilai f(a), fb = nilai f(b), xr = nilai tengah, fxr = nilai f(xr), e = nilai galat toleransi
        double a, b, fa, fb, fxr, e, xr = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan batas bawah: ");
        a = in.nextDouble();
        System.out.print("Masukkan batas atas: ");
        b = in.nextDouble();
        System.out.print("Masukkan nilai galat toleransi: ");
        e = in.nextDouble();
        System.out.print("Masukkan iterasi maksimum: ");
        nMax = in.nextInt();
        in.close();

        //Hitung f(a) dan f(b)
        fa = fungsi(a);
        fb = fungsi(b);

        // Jika f(a).f(b)>0 maka proses dihentikan karena tidak ada akar
        if (fa * fb > 0) {
            System.out.println("Tidak ditemukan akar pada range (" + a + "," + b + ")");
        } else {
            System.out.println("N \t     a \t\t     b \t\t    f(a) \t   f(b) \t   xr \t\t   f(xr)\tf(xr)f(a)<0\tf(xr)f(b)<0 \t |b-a| \t   |b-a|<e atau N > Nmax");
            // n = nilai iterasi
            int n = 0;
            // Selama |b-a| > e atau n < n maks maka proses akan berjalan
            while (Math.abs(b-a) > e || n < nMax ) {
                // Hitung nilai tengah xr
                xr = (a + b) / 2;
                //  Hitung f(xr)
                fxr = fungsi(xr);
                // selisihMutlah menampung selisih nilai dari b-a
                double selisihMutlak = Math.abs(b-a);

                // Bila f(xr).f(a)<0 maka b=xr dan f(b)=f(xr)
                if (fxr * fa < 0) {
                    b = xr;
                    fb = fxr;
                } 
                
                // Bila tidak a=xr dan f(a)=f(xr)
                else {
                    a = xr;
                    fa = fxr;
                }
                
                System.out.printf("%d    \t%f  \t%f  \t%f  \t%f \t%f  \t%f  \t%b", n, a, b, fa, fb, xr, fxr, fxr*fa<0);
                System.out.printf("  \t\t%b \t\t%f   \t%b\n", fxr*fb<0, selisihMutlak, Math.abs(selisihMutlak) < e || n > nMax);
                n++;
        }
        System.out.println("Jadi, akar persamaannya adalah = " + xr);
        }
    }

    public static double fungsi(double x){
        double y;
        y = Math.pow(x,3) - (10 * x) + 8;
        return y;
    }
}