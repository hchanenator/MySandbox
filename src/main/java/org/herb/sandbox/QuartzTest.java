/**
 * 
 */
package org.herb.sandbox;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.herb.sandbox.scheduling.MyJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author herb
 *
 */
public class QuartzTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(QuartzTest.class);
		
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			logger.info("Starting scheduler...");
			scheduler.start();
			
			JobDetail job = newJob(MyJob.class).withIdentity("MyJob", "group1").build();
			
			Trigger trigger = newTrigger().withIdentity("MyJob", "group1").startNow()
					.withSchedule(simpleSchedule()
					          .withIntervalInSeconds(2)
					          .repeatForever())
					.build();
			scheduler.scheduleJob(job, trigger);
			
			Thread.sleep(10000);

			logger.info("Shutting down scheduler...");
			scheduler.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	

}
