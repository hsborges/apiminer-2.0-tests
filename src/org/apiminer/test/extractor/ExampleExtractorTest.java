package org.apiminer.test.extractor;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apiminer.entities.api.ProjectStatus;
import org.apiminer.entities.api.Repository;
import org.apiminer.entities.api.RepositoryType;
import org.apiminer.tasks.AbstractTask;
import org.apiminer.tasks.TaskResult;
import org.apiminer.tasks.TasksController;
import org.apiminer.tasks.implementations.ExampleExtractorTask;
import org.apiminer.test.APIMinerTest;
import org.junit.Test;

public class ExampleExtractorTest extends APIMinerTest {

	@Test
	public void test() {
		Map<String, String> projects = new HashMap<String, String>();
		projects.put("AndroidClient", "/home/hudson/Documents/APIMINER2-TESTS/AndroidClient");
		projects.put("DesktopClient", "/home/hudson/Documents/APIMINER2-TESTS/DesktopClient");
		projects.put("WebClient", "/home/hudson/Documents/APIMINER2-TESTS/WebClient");
		
		List<AbstractTask> tasks = new LinkedList<AbstractTask>();
		
		for (Entry<String, String> entry : projects.entrySet()) {
			Repository repository = new Repository();
			repository.setRepositoryType(RepositoryType.LOCAL);
			repository.setUrlAddress(entry.getValue());
			repository.setSourceFilesDirectory(entry.getValue());
			
			ExampleExtractorTask task = new ExampleExtractorTask(entry.getKey(), "", "", ProjectStatus.UNKNOWN, RepositoryType.LOCAL, entry.getValue());
			
			tasks.add(task);
			
			TasksController.getInstance().addTask(task);
		}
		
		while (TasksController.getInstance().hasTasks()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
		for (AbstractTask task : tasks) {
			if (task.getResult() == TaskResult.FAILURE) {
				fail(task.getResult().getProblem().getLocalizedMessage());
			}
		}
	}

}
