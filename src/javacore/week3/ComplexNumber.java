package javacore.week3;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1,1);

        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof ComplexNumber)){
            return false;
        }
        return Double.compare(this.re, ((ComplexNumber) obj).re) == 0 &&  Double.compare(this.im, ((ComplexNumber) obj).im) == 0;
    }

    public int hashCode(){
        return Double.hashCode(re) + Double.hashCode(im);
    }
}
