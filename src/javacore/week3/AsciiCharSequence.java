package javacore.week3;

public class AsciiCharSequence implements CharSequence{

    public static void main(String[] args) {
        byte b[] = {40, 41, 42, 43, 44 , 45, 46}; // length = 7
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(b);
        System.out.println(asciiCharSequence.length());
        System.out.println(asciiCharSequence.charAt(6));
        System.out.println(asciiCharSequence);
        System.out.println(asciiCharSequence.subSequence(2, 5));
    }

    private byte aByte[];

    public AsciiCharSequence(byte b[]){
        this.aByte = b;
    }

    @Override
    public int length() {
        int i = 0;
        for (Byte ignored : aByte){
            i++;
        }
        return i;
    }

    @Override
    public char charAt(int index) {
        return (char)aByte[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte res[] = new byte[end - start];
        for (int i = 0; i < res.length; i++) {
            res[i] = aByte[start++];
        }
        return new AsciiCharSequence(res);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : aByte){
            stringBuilder.append((char)b);
        }
        return stringBuilder.toString();
    }
}
