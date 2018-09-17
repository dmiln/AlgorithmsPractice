package javacore.test;

public class B extends A{
        int  i;
    public static void main(String[] args) {
        B b = new B(2);
        System.out.println(b.field);

        boolean b1 = false;
        boolean b2 = false;
    }

    B(int i){
        super(i);
        this.i = i;
    }
}
