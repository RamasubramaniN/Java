import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mail
{
	public static void main(String args[]) throws Exception {

		String host = "192.168.10.205";
		String from = "test@localhost";
		String to = "test@localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(session);

		// Set the RFC 822 "From" header field using the 
		// value of the InternetAddress.getLocalAddress method.
		message.setFrom(new InternetAddress(from));

		// Add the given addresses to the specified recipient type.
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


		// Set the "Subject" header field.
		message.setSubject("hi..!");

		// Sets the given String as this part's content,
		// with a MIME type of "text/plain".
		message.setText("Hi ......");

		// Send message
		Transport.send(message);

		System.out.println("Message Send.....");
	}

}
