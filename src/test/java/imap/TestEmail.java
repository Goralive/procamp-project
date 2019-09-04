package imap;

import org.testng.annotations.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolik on 3/1/18.
 */
public class TestEmail {

    @Test
    public void azaza() throws InterruptedException, MessagingException, IOException {
        ImapClient client = new ImapClient("igortestnosov@gmail.com", "QAZxsw123");
        client.connect();
        List<Message> messages = client.findMessages(With.from("igortestnosov@gmail.com"), 2, 10);
        for(Message message : messages){
            MimeMultipart content = (MimeMultipart) message.getContent();
            System.out.println(message.getSubject());
        }
    }
}
