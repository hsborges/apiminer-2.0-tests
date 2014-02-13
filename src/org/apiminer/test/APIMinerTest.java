package org.apiminer.test;

import org.apiminer.tasks.TasksController;
import org.apiminer.util.LoggerUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class APIMinerTest {
	
	@BeforeClass
	public static void beforeClass(){
		LoggerUtil.logEvents();
	}
	
	@AfterClass
	public static void afterClass() {
		TasksController.getInstance().stop();
	}

}
