/**
 * Connecting to Yahoo via IMAP
 */
package org.herb.javamail.imap.tryout;

import javax.mail.Authenticator;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author herb
 * 
 */
public class MyYahooIMAP {

	/**
	 * @param args
	 * @throws MessagingException
	 */
	public static void main(String[] args) {
		MyYahooIMAP me = new MyYahooIMAP();

		MailProperties props = new MailProperties();
//		props.put("mail.debug", "true");

		try {
			me.checkUnreadMessages(props);
			me.sendTestEmail(props);
			me.checkUnreadMessages(props);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	private void checkUnreadMessages(MailProperties props)
			throws MessagingException {

		Session mailSession = Session.getInstance(props, null);

		Store store = mailSession.getStore("imaps");
		store.connect(props.getHost(), props.getUser(), props.getPassword());

		// Check email count
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		System.out.println("# of unread messages: "
				+ inbox.getUnreadMessageCount());
		
//		listFolders(store);
		
		close(store, inbox);

	}
	
	@SuppressWarnings("unused")
	private void listFolders(Store store) throws MessagingException {
		System.out.println("Checking folders");
		Folder[] folders = store.getDefaultFolder().list();
		for (Folder folder : folders) {
			System.out.println(folder.getName());
		}
	}

	private void sendTestEmail(MailProperties props) throws MessagingException {
		final MailProperties myProps = props;
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myProps.getUser(), myProps.getPassword());
			}
		};
		
		Session mailSession = Session.getInstance(props, auth);
		
		Message message = new MimeMessage(mailSession);

		message.setFrom(new InternetAddress(props.getUser()));

		message.setRecipient(Message.RecipientType.TO, new InternetAddress(
				"ww_hchan@yahoo.com"));

		message.setSubject("Test from my mail app");
		message.setText("Hello Herb!");
		
		Transport.send(message);
		
		udpateSentFolder(props, message);

	}
	
	private void udpateSentFolder(MailProperties props, Message msg) throws MessagingException {
		Session session = Session.getInstance(props);
		
		msg.setFlag(Flag.SEEN, true);
		
		Message[] msgs = new Message[1];
		msgs[0] = msg;
		
		Store store = session.getStore("imaps");
		store.connect(props.getHost(), props.getUser(), props.getPassword());
		
		Folder sentFolder = store.getFolder("Sent");
		sentFolder.open(Folder.READ_WRITE);
		sentFolder.appendMessages(msgs);
		
		close(store, sentFolder);
	}
	
	private void close(Store store, Folder folder) throws MessagingException {
		folder.close(false);
		store.close();
	}

}
