import java.util.Scanner;

public class Gcd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        System.out.println(gcd(firstNum,secondNum));
    }

    private static int gcd(int first, int second){
        if (first == 0){
            return second;
        }
        if (second == 0){
            return first;
        }
        if (first >= second){
            return gcd(first % second, second);
        }
        else {
            return gcd(first, second % first);
        }
    }
}
