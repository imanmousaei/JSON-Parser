import java.util.ArrayList;

public class Fibo {
    public static long calculateFib(int n) {
        if (n <= 1) {
            return 1L;
        }
        return calculateFib(n - 2) + calculateFib(n - 1);
    }
}