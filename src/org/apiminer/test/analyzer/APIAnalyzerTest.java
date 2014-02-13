package org.apiminer.test.analyzer;

import static org.junit.Assert.fail;

import org.apiminer.entities.api.ProjectStatus;
import org.apiminer.entities.api.RepositoryType;
import org.apiminer.tasks.TaskResult;
import org.apiminer.tasks.TaskStatus;
import org.apiminer.tasks.TasksController;
import org.apiminer.tasks.implementations.APIAnalyzerTask;
import org.apiminer.test.APIMinerTest;
import org.junit.Test;

public class APIAnalyzerTest extends APIMinerTest {

	@Test
	public void test() throws InterruptedException {
		APIAnalyzerTask apiAnalyzerTask = new APIAnalyzerTask("CBSoftAPI", "", "", ProjectStatus.UNKNOWN, RepositoryType.LOCAL, "/home/hudson/Documents/APIMINER2-TESTS/CBSoftAPI", true, true, true);

		TasksController.getInstance().addTask(apiAnalyzerTask);
		
		while (apiAnalyzerTask.getStatus() != TaskStatus.FINISHED) {
			Thread.sleep(1000);
		}
		
		final TaskResult result = apiAnalyzerTask.getResult();
		if (result == TaskResult.FAILURE) {
			fail(result.getProblem().getLocalizedMessage());
		}
	}

}
