/**
 * 
 */
package org.herb.sandbox.system;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.herb.sandbox.system.PICSProperties;
import org.herb.sandbox.system.logging.LogConfigurationSandbox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

/**
 * @author herb
 *
 */
public class PropertiesLoaderTest extends TestCase {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testLoadPropertiesAsResource() {
		String propertiesFile = "some.properties";
		String someKey = "base.dir";
//		ClassLoader cl = LogConfigurationSandbox.class.getClassLoader();
		PICSProperties props = new PICSProperties();
		try {
//			props.load(cl.getResourceAsStream(propertiesFile));
//			props.load(new FileReader(propertiesFile));
//			props.loadAsFileDirectly(propertiesFile);
			props.loadAsResource(propertiesFile);
			assertEquals("/temp", props.getProperty(someKey));
		} catch (IOException e) {
			log.info("Problem trying to load " + propertiesFile);
			e.printStackTrace();
		}
	}

}
