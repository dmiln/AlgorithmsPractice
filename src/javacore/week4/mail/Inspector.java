package javacore.week4.mail;

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage){
            Package pack = ((MailPackage) mail).getContent();
            if (pack.getContent().equals("weapons") || pack.getContent().equals("banned substance")){
                throw new IllegalPackageException("IllegalPackageException");
            }
            if (pack.getContent().startsWith("stones")){
                throw new StolenPackageException("StolenPackageException");
            }
        }
        return mail;
    }
}
