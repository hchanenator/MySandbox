/**
 * 
 */
package org.herb.ftp.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author herb
 *
 */
public class FTPProperties {
	
	private final Properties props = new Properties();
	private final Logger log = LoggerFactory.getLogger(FTPProperties.class);
	
	public FTPProperties() {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("ftp.properties"));
		} catch (IOException iox) {
			log.info("Unable to load FTP properties file. " + iox.getMessage());
		}
	}
	
	public String getFTPUser() { return props.getProperty("ftp.user"); }
	
	public String getFTPPassword() { return props.getProperty("ftp.password"); }
	
	public String getFTPAddress() { return props.getProperty("ftp.serverAddress"); }

}
