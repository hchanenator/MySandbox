/**
 * 
 */
package org.herb.sandbox.scheduling;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author herb
 *
 */
public class MyJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Hello Herb!");
		
	}

}
