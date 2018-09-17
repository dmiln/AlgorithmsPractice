package javacore.week4.mail;

public class Thief implements MailService{
    private int minPrice;
    private int stolenValue;

    public Thief(int minPrice){
        this.minPrice = minPrice;
        stolenValue = 0;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage){
            MailPackage mailPackage = (MailPackage)mail;
            int price = mailPackage.getContent().getPrice();
            if (price >= minPrice){
                stolenValue += price;
                Package emptyPackage = new Package("stones instead of " + mailPackage.getContent().getContent(),0);
                mail = new MailPackage(mailPackage.from, mailPackage.to, emptyPackage);
            }
        }

        return mail;
    }

    public int getStolenValue(){
        return stolenValue;
    }
}
