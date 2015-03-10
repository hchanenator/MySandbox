package org.herb.sandbox.ftp.util;
/**
 * 
 */


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.herb.ftp.util.FTPProperties;
import org.herb.ftp.util.FTPStreamListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

/**
 * @author herb
 * 
 */
public class FTPPropertiesTest extends TestCase {

	private final Logger log = LoggerFactory.getLogger(FTPProperties.class);

	private FTPProperties props;
	private final FTPClient ftp = new FTPClient();

	protected void setUp() {
		props = new FTPProperties();
	}

	/**
	 * Test method for {@link org.herb.ftp.util.FTPProperties#getFTPUser()}.
	 */
	public void testGetFTPUser() {
		// fail("Not yet implemented");
		assertEquals("ftpinout", props.getFTPUser());
		log.info("ftp.user = " + props.getFTPUser());
	}

	/**
	 * Test method for {@link org.herb.ftp.util.FTPProperties#getFTPPassword()}.
	 */
	public void testGetFTPPassword() {
		assertEquals("CygnusX1", props.getFTPPassword());
		log.info("ftp.password = " + props.getFTPPassword());
	}

	/**
	 * Test method for {@link org.herb.ftp.util.FTPProperties#getFTPURL()}.
	 */
	public void testGetFTPAddress() {
		// fail("Not yet implemented");
		log.info("ftp.serverAddress = " + props.getFTPAddress());
		assertEquals("www.no1we.com", props.getFTPAddress());
	}

	public void testGetFTPConnection() {
		try {

			ftp.connect(props.getFTPAddress());
			ftp.enterLocalPassiveMode();
			ftp.setSoTimeout(2000);
			boolean login = ftp.login(props.getFTPUser(),
					props.getFTPPassword());
			assertEquals(true, login);
			log.info(ftp.getReplyString());
			ftp.disconnect();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}

	public void testGetFTPDirectoryList() {
		try {
			ftp.connect(props.getFTPAddress());
			boolean login = ftp.login(props.getFTPUser(),
					props.getFTPPassword());
			assertEquals(true, login);
			ftp.enterLocalPassiveMode();
			FTPFile[] dirs = ftp.listDirectories();
			assertNotNull(dirs);
		} catch (SocketException e) {
			log.info(e.getStackTrace().toString());
			e.printStackTrace();
		} catch (IOException e) {
			log.info(e.getStackTrace().toString());
			e.printStackTrace();
		}
	}

	public void testChangeDirectory() {
		try {
			ftp.connect(props.getFTPAddress());
			boolean login = ftp.login(props.getFTPUser(),
					props.getFTPPassword());
			assertEquals(true, login);
			ftp.enterLocalPassiveMode();
			boolean changeDir = ftp.changeWorkingDirectory("Herb");
			assertEquals(true, changeDir);
			FTPFile[] files = ftp.listFiles();
			assertNotNull(files);
//			for (FTPFile file : files) {
//				log.info(file.getName() + "\t" + file.getSize());
//			}
			FTPFile file = ftp.mlistFile("Returns.sfx");
			assertNotNull(file);
			log.info(file.getName() + "\t" + file.getSize());
			ftp.disconnect();
		} catch (SocketException e) {
			log.info(e.getStackTrace().toString());
			e.printStackTrace();
		} catch (IOException e) {
			log.info(e.getStackTrace().toString());
			e.printStackTrace();
		}
	}

	public void testGetATestFile() {
		try {
			// ftp.addProtocolCommandListener(new PrintCommandListener(new
			// PrintWriter(System.out)));
			int reply;
			ftp.connect(props.getFTPAddress());
			ftp.setSoTimeout(2000);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				log.info("Exception in connecting to FTP Server");
			}
			assertEquals(220, reply);
			boolean login = ftp.login(props.getFTPUser(),
					props.getFTPPassword());
			assertEquals(true, login);
			ftp.enterLocalPassiveMode();
			boolean changeDir = ftp.changeWorkingDirectory("Herb");
			assertEquals(true, changeDir);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);			
			boolean retrieveFile = ftp.retrieveFile("Returns.sfx", new FileOutputStream(
					"/temp/Returns2.sfx"));
			assertEquals(true, retrieveFile);
			ftp.disconnect();
		} catch (SocketException e) {
			log.info(e.getStackTrace().toString());
			e.printStackTrace();
		} catch (IOException e) {
			log.info(e.getStackTrace().toString());
			e.printStackTrace();
		}
	}
	
	public void testShowProgress() {
		try {
			int reply;
			ftp.connect(props.getFTPAddress());
			ftp.setSoTimeout(2000);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				log.info("Exception in connecting to FTP Server");
			}
			assertEquals(220, reply);
			boolean login = ftp.login(props.getFTPUser(),
					props.getFTPPassword());
			assertEquals(true, login);
			ftp.enterLocalPassiveMode();
			ftp.setFileType(FTP.BINARY_FILE_TYPE);			
			boolean changeDir = ftp.changeWorkingDirectory("Herb/FreshAdv");
			assertEquals(true, changeDir);
			ftp.setCopyStreamListener(new FTPStreamListener());
//			boolean retrieveFile = ftp.retrieveFile("20150302 FA Intl LIVEDATA.rar", new FileOutputStream(
//					"/temp/20150302 FA Intl LIVEDATA.rar"));
			ftp.disconnect();
		} catch (SocketException e) {
			log.info(e.getStackTrace().toString());
			e.printStackTrace();
		} catch (IOException e) {
			log.info(e.getStackTrace().toString());
			e.printStackTrace();
		}
	}

}
