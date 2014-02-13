package org.apiminer.test.recommender;

import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.apiminer.daos.MiningDAO;
import org.apiminer.entities.mining.MiningResult;
import org.apiminer.tasks.TaskResult;
import org.apiminer.tasks.TaskStatus;
import org.apiminer.tasks.TasksController;
import org.apiminer.tasks.implementations.PatternsRecommenderTask;
import org.apiminer.test.APIMinerTest;
import org.junit.Test;

public class AssociationsRecommenderTest extends APIMinerTest {

	@Test
	public void test() {
		PatternsRecommenderTask task = new PatternsRecommenderTask(new LinkedList<MiningResult>(new MiningDAO().findAll()).getLast());
		
		TasksController.getInstance().addTask(task);
		
		while (task.getStatus() != TaskStatus.FINISHED) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
		if (task.getResult() == TaskResult.FAILURE) {
			fail(task.getResult().getProblem().getLocalizedMessage());
		}
	}

}
