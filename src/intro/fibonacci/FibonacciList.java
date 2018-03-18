package intro.fibonacci;

import java.util.ArrayList;

public class FibonacciList {

    //будем брать число Фибоначчи по модулю
    private ArrayList<Integer> cache = new ArrayList<>();
    private static final int MOD = (int)1e9 + 7;

    private void run(int n){
        System.out.println(n + ": " + fibonacci(n));
    }

    private int fibonacci(int n) {
        cache.add(0);
        cache.add(1);
        for (int i = cache.size(); i <= n; i++){
            cache.add((cache.get(i - 1) + cache.get(i - 2))% MOD);
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new FibonacciList().run(10000);
        new FibonacciList().run(100000);
        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime) + "ms");
    }
}
