/**
 * 
 */
package org.herb.sandbox.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import org.apache.log4j.Logger;




import org.herb.sandbox.system.PICSProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author herb
 * 
 */
public class SMTPEmailTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	private final Logger logger = Logger.getLogger(this.getClass());

	PICSProperties mailProps;

	public SMTPEmailTest(Properties mailProps) throws ClassCastException {
		this.mailProps = (PICSProperties) mailProps;
	}

	public void emailTest(String subject, StringBuilder text) {
		final String sender = mailProps.getProperty("email.sender.address");
		
		Session session = Session.getInstance(mailProps);

		session.setDebug(true);

		Message msg = new MimeMessage(session);
		

		try {
			msg.setFrom(new InternetAddress(sender));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(sender));
			
			msg.setSubject(subject);
//			msg.setText(text.toString()); // for plain text
			msg.setContent(text.toString(), "text/html; charset=utf-8"); // for HTML
			

			Transport.send(msg);
			logger.info("Email sent.  Check your inbox");

		} catch (AddressException e) {
			logger.error("Address error", e);
			e.printStackTrace();
		} catch (MessagingException e) {
			logger.error("Messaging error", e);
			e.printStackTrace();
		}
	}
}
