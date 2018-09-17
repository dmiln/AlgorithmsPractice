package javacore.week4.mail;

public class UntrustworthyMailWorker implements MailService{

    private RealMailService realMailService;
    private MailService[] mailServices;

    public UntrustworthyMailWorker(MailService[] mailServices){
        this.mailServices = mailServices;
        realMailService = new RealMailService();
    }

    public RealMailService getRealMailService(){
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mailServices.length == 0){
            return realMailService.processMail(mail);
        }
        Sendable sendable = mailServices[0].processMail(mail);
        for (int i = 1; i < mailServices.length; i++) {
            sendable = mailServices[i].processMail(sendable);
        }
        return realMailService.processMail(sendable);
    }
}
