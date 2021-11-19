public class MetodeSimpson {
    public static double f(double x) {
        return (Math.pow(x, 0.1)) * (1.2 - x) * (1 - Math.exp(20*(x-1)));
    }

    public static double simpEq(double n, double a, double b) {
        double h = (b-a) / n;
        double x = a;
        double sum = f(x);

        for (int i = 1; i < n-2; i+=2) {
            x += h;
            sum += 4*f(x);
            x += h;
            sum += 2*f(x);
        }

        x += h;
        sum += 4 * f(x);
        sum += f(b);

        double hasil = (b-a) * sum / (3 * n);
        return hasil;
    }
    public static void main(String[] args) {
        System.out.println(simpEq(10, 0, 1));
    }
}