package org.apiminer.test.mining;

import static org.junit.Assert.fail;

import org.apiminer.tasks.TaskResult;
import org.apiminer.tasks.TaskStatus;
import org.apiminer.tasks.TasksController;
import org.apiminer.tasks.implementations.AssociationRulesMineTask;
import org.apiminer.test.APIMinerTest;
import org.junit.Test;

import weka.associations.FPGrowth;

public class AssociationRulesMineTest extends APIMinerTest {

	@Test
	public void test() {
		AssociationRulesMineTask associationRulesMineTask = new AssociationRulesMineTask(FPGrowth.class, 4, 0.75, 5);
		TasksController.getInstance().addTask(associationRulesMineTask);
		
		while (associationRulesMineTask.getStatus() != TaskStatus.FINISHED) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
		if (associationRulesMineTask.getResult() == TaskResult.FAILURE) {
			fail(associationRulesMineTask.getResult().getProblem().getLocalizedMessage());
		}
	}

}
