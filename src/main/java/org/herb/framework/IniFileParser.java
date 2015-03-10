package org.herb.framework;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

/**
 * Simple File utility class for the PreLauncher proof of concept
 * @author herb
 *
 */
public class IniFileParser {
	
	private Wini picsIniFile;
	
	public IniFileParser(File iniFile) {
		try {
			picsIniFile = new Wini(iniFile);
		} catch (InvalidFileFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isFileFound(String pathToFile) {
		File file = new File(pathToFile);
		return file.exists();
	}
	
	public Properties getPicsIniProperties(File iniFile) {
		Properties props = new Properties();
		loadMyProperties(props, iniFile);
		
		return props;
	}
	
	private void loadMyProperties(Properties props, File iniFile) {
		try {
			props.load(new FileReader(iniFile));
			addToSystemProperties(props);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addToSystemProperties(Properties props) {
		Set<String> keys = props.stringPropertyNames();
		for(String key : keys) {
			System.setProperty(key, props.getProperty(key));
		}
	}
	
	public String getPicsIniProperty(String section, String propertyKey) {
		return picsIniFile.get(section, propertyKey);
	}
	

}
