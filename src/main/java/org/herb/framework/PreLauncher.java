
package org.herb.framework;

import java.io.File;
import java.util.Properties;

/**
 * Simple test class for proof of concept to launch PRE utilizing same 
 * runtime parameters as configured in PICS.ini as the current
 * PICS application
 * 
 * <hr>
 * Hi Herb,<br>
 * <br>
 * gcPREDir comes form the pics.ini file under the seciont PATHINFO.  IT is REPOSTSPATH.<br>
 * [PATHINFO]<br>
 * REPORTSPATH=w:\sqsdk30\pre30\<br>
 * APPSERVERPATH=w:\proddev\<br>
 * DATASOURCENAME001=Prod Data<br>
 * DATASOURCEPATH001=w:\proddev\livedata\<br>
 * DATASOURCENAME002=Super Packer<br>
 * DATASOURCEPATH002=w:\prodinv\suprpakr\<br>
 * <br>
 * The homedir is current working directory set the shortcut that called PICS.<br>
 * <br>
 * PRE needs the workstationPath because it needs the information in the users PICS.ini under PATHINFO.
 *<br>
 * Jonathan Campbell<br>
 * WaudWare Incorporated<br>
 * <hr>
 * @author herb
 *
 */
public class PreLauncher {
	
	private static final String INIFILE = "Y:\\prodrun\\pics.ini";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File iniFile = new File(INIFILE);
		IniFileParser parser = new IniFileParser(iniFile);
		Properties props = parser.getPicsIniProperties(iniFile);
		System.out.println(System.getProperty("Server"));
//		System.getProperties().list(System.out);
		System.out.println(parser.getPicsIniProperty("PATHINFO", "REPORTSPATH"));
		System.exit(0);
		
	}

}
