public class Fibonacci {
    public static void main(String[] args) throws Exception {
        System.out.println(ficcal(50));

    }


    public static int calculateFib(int n) throws Exception{
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int[] fib = new int[n + 1];
        return calculateFibHelper(n, fib);
    }

    private static int calculateFibHelper(int n, int[] fib) {
        if (n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        } else if (fib[n] != 0) {
            return fib[n];
        }
        int ans =  calculateFibHelper(n-1, fib) + calculateFibHelper(n-2, fib);
        fib[n] = ans;
        return ans;
    }

    public static long ficcal(int n) {
        long[] fib = {0, 1};
        if (n <= 1) {
            return fib[n];
        }
        long fibN = 0;
        long fibNminus1 = 1;
        long fibNminus2 = 0;
        for (int i = 2; i <= n; i++) {
           fibN = fibNminus1 + fibNminus2;
           fibNminus2 = fibNminus1;
           fibNminus1 = fibN;
        }
        return fibN;
    }
}
