package org.apiminer.test.analyzer;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apiminer.entities.api.ProjectStatus;
import org.apiminer.entities.api.RepositoryType;
import org.apiminer.tasks.TaskResult;
import org.apiminer.tasks.TasksController;
import org.apiminer.tasks.implementations.ClientAnalyzerTask;
import org.apiminer.test.APIMinerTest;
import org.junit.Test;

public class ClientsAnalyzerTest extends APIMinerTest {

	@Test
	public void test() throws InterruptedException {
		Map<String, String> projects = new HashMap<String, String>();
		projects.put("AndroidClient", "/home/hudson/Documents/APIMINER2-TESTS/AndroidClient");
		projects.put("DesktopClient", "/home/hudson/Documents/APIMINER2-TESTS/DesktopClient");
		projects.put("WebClient", "/home/hudson/Documents/APIMINER2-TESTS/WebClient");
		
		List<ClientAnalyzerTask> tasks = new LinkedList<ClientAnalyzerTask>();
		
		for (Entry<String, String> entry : projects.entrySet()) {
			ClientAnalyzerTask clientAnalyzerTask = new ClientAnalyzerTask(entry.getKey(), "", "", ProjectStatus.UNKNOWN, RepositoryType.LOCAL, entry.getValue());
			TasksController.getInstance().addTask(clientAnalyzerTask);
			tasks.add(clientAnalyzerTask);
		}
		
		while (TasksController.getInstance().hasTasks()) {
			Thread.sleep(1000);
		}
		
		for (ClientAnalyzerTask task : tasks) {
			if (task.getResult() == TaskResult.FAILURE) {
				fail(task.getResult().getProblem().getLocalizedMessage());
			}
		}
	}

}
