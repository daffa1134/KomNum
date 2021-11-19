public class MetodeTrapesium{
    public static double f(double x) {
        return (Math.pow(x, 0.1)) * (1.2 - x) * (1 - Math.exp(20*(x-1)));
    }
    
    public static double trapEq(double n, double a, double b) {
        double h = (b-a) / n;
        double x = a;

        double sum = f(x);

        for (int i = 0; i < n-1; i++) {
            x += h;
            sum += 2*f(x);
        }
        sum += f(b);
        double hasil = (b-a) * sum / (2*n);
        return hasil;
    }

    public static void main(String[] args) {
        System.out.println(trapEq(10, 0, 1));
    }
}