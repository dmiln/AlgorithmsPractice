package javacore.week4.mail;

public class IllegalPackageException extends RuntimeException {

    public IllegalPackageException(){
        super();
    }

    public IllegalPackageException(String msg){
        super(msg);
    }

    public IllegalPackageException(String message, Throwable cause){
        super(message,cause);
    }
}
