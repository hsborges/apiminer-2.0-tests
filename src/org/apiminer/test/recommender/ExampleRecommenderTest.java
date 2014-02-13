package org.apiminer.test.recommender;

import static org.junit.Assert.fail;

import org.apiminer.tasks.TaskResult;
import org.apiminer.tasks.TaskStatus;
import org.apiminer.tasks.TasksController;
import org.apiminer.tasks.implementations.ExampleRecommenderTask;
import org.apiminer.test.APIMinerTest;
import org.junit.Test;

public class ExampleRecommenderTest extends APIMinerTest {

	@Test
	public void test() throws InterruptedException {
		ExampleRecommenderTask task = new ExampleRecommenderTask();
		
		TasksController.getInstance().addTask(task);
		
		while (task.getStatus() != TaskStatus.FINISHED) {
			Thread.sleep(1000);
		}
		
		if (task.getResult() == TaskResult.FAILURE) {
			fail(task.getResult().getProblem().getLocalizedMessage());
		}
	}

}
