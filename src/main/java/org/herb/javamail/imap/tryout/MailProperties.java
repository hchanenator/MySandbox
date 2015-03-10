/**
 * 
 */
package org.herb.javamail.imap.tryout;

import java.util.Properties;

/**
 * @author herb
 *
 */
public class MailProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8026277553055999892L;
	
	public MailProperties() {
		setHost("imap.mail.yahoo.com");
		setPort("993");
		setIMAPSSLFlag("true");
		
		setSMTPHost("smtp.mail.yahoo.com");
		setSMTPPort("465");
		setSMTPAuthFlag("true");
		setSMTPSSLFlag("true");
		
		setUser("ww_hchan@yahoo.com");
		setUserPassword("jPics1234");
	}
	
	private void setHost(String hostURL) {
		setProperty("mail.imap.host", hostURL);
	}
	
	public String getHost() { return getProperty("mail.imap.host"); }
	
	private void setUser(String userName) {
		setProperty("username", userName);
	}
	
	public String getUser() { return getProperty("username"); }
	
	private void setUserPassword(String userPasswd) {
		setProperty("pwd", userPasswd);
	}
	
	public String getPassword() { return getProperty("pwd"); }
	
	private void setPort(String portNumber) {
		setProperty("mail.imap.port", portNumber);
	}
	
	public String getPort() { return getProperty("mail.imap.port"); }
	
	private void setIMAPSSLFlag(String value) {
		setProperty("mail.imap.starttls.enable", value);
	}
	
	private void setSMTPHost(String smtpHost) {
		setProperty("mail.smtp.host", smtpHost);
	}
	
	public String getSMTPHost() { return getProperty("mail.smtp.host"); }
	
	private void setSMTPPort(String port) {
		setProperty("mail.smtp.port", port);
	}
	
	public String getSMTPPort() { return getProperty("mail.smtp.port"); }
	
	private void setSMTPAuthFlag(String value) {
		setProperty("mail.smtp.auth", value);
	}
	
	public String getSMTPAuthFlag() { return getProperty("mail.smtp.auth"); }
	
	private void setSMTPSSLFlag(String value) {
	    setProperty("mail.smtp.ssl.enable", value);
	}
	
	public String getSMTPSSLFlag() { return getProperty("mail.smtp.ssl.enable"); }
}
