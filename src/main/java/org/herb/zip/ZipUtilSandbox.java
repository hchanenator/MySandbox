/**
 * 
 */
package org.herb.zip;

import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author herb
 * 
 */
public class ZipUtilSandbox {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public void unzipFile(String file, String destination) {
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(file);
		} catch (ZipException e) {
			log.info("Problem finding file " + file);
			e.printStackTrace();
		}
		try {
			log.info("Begin extracting files...");
			List<?> fileHeaders = zipFile.getFileHeaders();
			for (int i = 0; i < fileHeaders.size(); i++) {
				FileHeader fileHeader = (FileHeader) fileHeaders.get(i);
				log.info("Extracting " + fileHeader.getFileName());
				zipFile.extractFile(fileHeader, destination);
			}
		} catch (ZipException e) {
			log.info("Problem unzipping file to " + destination);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final String zippedFile = "/temp/hibernate35.zip";
		final String destDir = "/temp";

		ZipUtilSandbox sandbox = new ZipUtilSandbox();
		sandbox.unzipFile(zippedFile, destDir);
	}

}
