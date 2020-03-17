import java.util.Scanner;

public class Fibo {
    static int n;
    public static long[] fib = new long[n + 1];

    public static long Fib(int n) {
        if (fib[n] != 0) {
            return fib[n];
        }
        return Fib(n - 2) + Fib(n - 1);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        fib[0] = 1;
        fib[1] = 1;

        System.out.println(Fib(n));

    }
}