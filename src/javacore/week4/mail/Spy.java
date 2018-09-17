package javacore.week4.mail;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService{
    Logger LOGGER;

    public Spy(Logger logger){
        LOGGER = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage){
            MailMessage mailMessage = (MailMessage)mail;
            if (mail.getTo().equals("Austin Powers") || mail.getFrom().equals("Austin Powers")){
                LOGGER.log(Level.WARNING, "WARN: Detected target mail correspondence: from {0} to {1} \"{2}\"",new Object[]{mailMessage.getFrom(),mailMessage.getTo(), mailMessage.getMessage()});
            }else{
                LOGGER.log(Level.INFO,"INFO: Usual correspondence: from {0} to {1}",new Object[]{mailMessage.getFrom(),mailMessage.getTo()});
            }
        }
        return mail;
    }
}
