public class SimpleFibonacci {

    private static final int MOD = (int)1e9 + 7;

    private void run(int n){
        System.out.println(n + ": " + fibonacci(n));
    }

    private int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++){
            c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new SimpleFibonacci().run(10000);
        new SimpleFibonacci().run(100000);
        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime) + "ms");
    }
}
