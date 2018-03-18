package intro.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer, BigInteger> cache = new HashMap<>();
    private int calls = 0;

    private void run(int n){
        System.out.println(n + ": " + fibonacci(n));
        System.out.println("calls: " + calls);
    }

    private BigInteger fibonacci(int n) {
        calls++;
        if (n < 2){
            return BigInteger.valueOf(n);
        }
        if (cache.containsKey(n)){
            return cache.get(n);
        }else{
            for (int i = 2; i <= n; i++){
                BigInteger result = fibonacci(i - 1).add(fibonacci(i - 2));
                cache.put(i, result);
            }
            return cache.get(n);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Fibonacci().run(10000);
        new Fibonacci().run(100000);
        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime) + "ms");
    }
}
