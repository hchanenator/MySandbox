/**
 * 
 */
package org.herb.sandbox;

import java.io.IOException;

import org.herb.sandbox.database.connection.DBFConnection;
import org.herb.sandbox.mail.SMTPEmailSandbox;
import org.herb.sandbox.system.PICSProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author herb
 * 
 */
public class SimpleDBFApp {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  // use slf4j
//	private Logger logger = Logger.getLogger(SimpleDBFApp.class);  // use log4j

	private PICSProperties dbProps, mailProps;
	private DBFConnection conn;

	public SimpleDBFApp() {
		try {
			dbProps = new PICSProperties();
			dbProps.loadAsResource("database.properties");
			conn = new DBFConnection(dbProps);
			
			mailProps = new PICSProperties();
			mailProps.loadAsResource("email.properties");
			
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			logger.error("Failed to load properties", ioe);
		} catch (Exception ex) {
			logger.error("Failed to load properties", ex);
		}
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		final String altDBURUL = "jdbc:dbf:/M:/Prodinv/SuprPakr";
//		final String sql = "select count(*) from todo";
//		final String sql = "select reccount() from livedata.todonote";
		final String sql = "select TNTNKEY, TNBRDCSTNT from livedata.todonote where tntdkey = 'TD00022148'";

		SimpleDBFApp me = new SimpleDBFApp();
		me.connect();
		me.conn.runCountQuery(sql);
//		me.mailToMe();
	}

	private void connect() {
		conn.connect();
	}
	
	private void mailToMe()  {
		SMTPEmailSandbox test = new SMTPEmailSandbox(mailProps);
		
		StringBuilder text = new StringBuilder();
		text.append("Hello world!<br>");
		text.append("<b>This should be in bold</>");
		
		test.emailTest("This is a test from JavaMail", text);
	}

}
