/**
 * 
 */
package org.herb.ftp.util;

import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author herb
 *
 */
public class FTPStreamListener implements CopyStreamListener {
	private final Logger logger = LoggerFactory
			.getLogger(FTPStreamListener.class);
	private long megsTotal = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.net.io.CopyStreamListener#bytesTransferred(org.apache
	 * .commons.net.io.CopyStreamEvent)
	 */
	public void bytesTransferred(CopyStreamEvent event) {
		bytesTransferred(event.getTotalBytesTransferred(),
				event.getBytesTransferred(), event.getStreamSize());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.net.io.CopyStreamListener#bytesTransferred(long,
	 * int, long)
	 */
	public void bytesTransferred(long totalBytesTransferred,
			int bytesTransferred, long streamSize) {
		long megs = totalBytesTransferred / 1000000;
		for (long l = megsTotal; l < megs; l++) {
			System.err.print("#");
		}
		megsTotal = megs;
	}

}
