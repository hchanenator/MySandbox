/**
 * 
 */
package org.herb.sandbox.system.logging;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author herb
 * 
 */
public class LogConfigurationSandbox {

	private final static Logger log = Logger.getLogger(LogConfigurationSandbox.class);

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ClassLoader cl = LogConfigurationSandbox.class.getClassLoader();
		Properties log4j = new Properties();
		log4j.load(cl.getResourceAsStream("log4j.properties"));

		// BasicConfigurator replaced with PropertyConfigurator.
		PropertyConfigurator.configure(log4j);

		log.info("Entering application.");
		
//		FileAppender appender = (FileAppender)Logger.getRootLogger().getAppender("fileAppender");
//		System.out.println(appender.getFile());
		log.info("Exiting application.");
	}
}
