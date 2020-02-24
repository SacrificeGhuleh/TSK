package tsk2020.CV01;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static boolean isTriangle(double a, double b, double c) {
        if (a <= 0) return false;
        if (b <= 0) return false;
        if (c <= 0) return false;

        //a is max
        if (a >= b && a >= c) {
            return b + c > a;
        }

        //b is max
        if (b >= a && b >= c) {
            return a + c > b;
        }

        //c is max
        if (c >= a && c >= b) {
            return a + b > c;
        }
        return false;
    }


}
