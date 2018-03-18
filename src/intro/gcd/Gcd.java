package intro.gcd;

import java.math.BigInteger;

public class Gcd {

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        //new Gcd().run();
        new Gcd().runForBig();
        long timeEnd = System.currentTimeMillis();
    }

    private void run(){
        System.out.println(gcd(423532534534545L,43243253452345432L));
    }

    private void runForBig(){
        BigInteger a = new BigInteger("31253485347878987954389578934789578934895734897589348");
        BigInteger b = new BigInteger("89094852364239849235498327489076544324");
        System.out.println(gcdForBig(a, b));
    }

    private long gcd(long first, long second){
        System.out.println(first + " " + second);
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

    private BigInteger gcdForBig(BigInteger a, BigInteger b){
        while(true){
            System.out.println(a + " " + b);
            if (a.equals(BigInteger.ZERO)){
                return b;
            }
            if (b.equals(BigInteger.ZERO)){
                return a;
            }
            if (a.compareTo(b) >= 0){
                // a <- a % b
                a = a.mod(b);
            }else{
                // b <- b % a
                b = b.mod(a);
            }
        }
    }
}
