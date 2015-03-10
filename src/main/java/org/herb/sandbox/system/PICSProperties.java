/**
 * 
 */
package org.herb.sandbox.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.slf4j.Logger;
//import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author herb
 * 
 */
public class PICSProperties extends Properties {
	
	private static final long serialVersionUID = -722518638866593973L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	private Logger logger = Logger.getLogger(SimpleDBFApp.class);  // use log4j
	
	public PICSProperties() {}
	
	public void loadAsFileDirectly(String propsToLoad) throws IOException, NullPointerException {
		logger.info("Loading property file " + propsToLoad);
		load(new FileInputStream(new File(propsToLoad)));
	}
	
	public void loadAsResource(String propsToLoad) throws IOException, NullPointerException {
		logger.info("Loading property file " + propsToLoad);
		ClassLoader classLoader = this.getClass().getClassLoader();
		load(classLoader.getResourceAsStream(propsToLoad));
	}
}
