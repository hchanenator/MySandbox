/**
 * 
 */
package org.herb.simplesmtp;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author herb
 *
 */
public class ReallySimpleSMTPSandbox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		final String user = "ww_hchan@yahoo.com";
//		final String pwd = "jPics1234";
//		final String host = "smtp.mail.yahoo.com";
//		final String port = "465";
//		final String useSSL = "true";
//		final String needsAuth = "true";
		
		final String user = "waudware\\herb";
		final String pwd = "karench@n2";
		final String host = "mail.waudware.com";
		final String port = "25";
		@SuppressWarnings("unused")
		final String useSSL = "true";
		final String needsAuth = "true";
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", needsAuth);
		props.put("mail.smtp.port", port);
//		props.put("mail.smtp.ssl.enable", useSSL);
		props.put("mail.smtp.starttls.required","true");
		props.put("mail.debug", true);
		props.put("mail.smtp.ssl.trust", host);
		
		Session session = Session.getInstance(props, new Authenticator() {
			private PasswordAuthentication pa = new PasswordAuthentication(user, pwd);
			
			@Override
			public PasswordAuthentication getPasswordAuthentication() { return pa; }
		});
		
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		
		try {
			msg.setFrom(new InternetAddress("herb@waudware.com"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("herb@waudware.com"));
			msg.setSubject("This is a test from JavaMail");
			msg.setText("Hello world!");;
			
			Transport.send(msg);
			System.out.println("Email sent.  Check your inbox");
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
