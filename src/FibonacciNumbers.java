import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciNumbers {

    public static int fibonacciUpTo40(){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] fibbonacciNumbers = new int[length];
        fibbonacciNumbers[0] = 1;
        fibbonacciNumbers[1] = 1;
        for (int i = 2; i < length; i++){
            fibbonacciNumbers[i] = fibbonacciNumbers[i - 1] + fibbonacciNumbers[i - 2];
        }

        return fibbonacciNumbers[length-1];
    }

    public static int lastNumber(){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] fibbonacciNumbers = new int[length + 1];
        fibbonacciNumbers[0] = 0;
        fibbonacciNumbers[1] = 1;
        for (int i = 2; i <= length; i++){
            fibbonacciNumbers[i] = (fibbonacciNumbers[i - 1] + fibbonacciNumbers[i - 2]) % 10;
        }

        return fibbonacciNumbers[length];
    }

    public static long gcdTwoBigFib(long n, long m){
        ArrayList<Long> rest = new ArrayList<>();
        rest.add((long)0);
        rest.add((long)1);
        for (int i = 2; i < m * 6; i++){
            rest.add((rest.get(i - 1) + rest.get(i - 2)) % m);
            if (rest.get(i) == 1 && rest.get(i - 1) == 0){
                rest.remove(rest.size()- 1);
                rest.remove(rest.size()- 1);
                break;
            }
        }
        long period = rest.size();
        int num = (int)(n % period);
        return rest.get(num);
    }
}
