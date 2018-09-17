package javacore.test;

public class Main {
    static class Threader extends Thread{
        @Override
        public void run() {
            System.out.println("In Threader");
        }
    }

    static class Pooler extends Thread{
        public Pooler(){}
        public Pooler(Runnable r){
            super(r);
        }

        @Override
        public void run() {
            System.out.println("In Pooler");
        }
    }

    public static void main(String[] args) {
        Threader t = new Threader();
        Thread h = new Pooler(t);
        h.start();
    }
}
