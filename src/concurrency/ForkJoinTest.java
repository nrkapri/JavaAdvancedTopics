package concurrency;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTest extends RecursiveAction {
	
	String work ="";
	final int THRESHOLD= 4;


	ForkJoinTest(String work)
	{
		this.work=work; 
	}
	
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if(work.length()>THRESHOLD)
		{
			ForkJoinTask.invokeAll(createSubTasks());
		}
		else
		{
			process(work);
		}
	}
	
	private List<ForkJoinTask> createSubTasks() {
		
		List<ForkJoinTask>  subtasks= new ArrayList<ForkJoinTask>();
		
		subtasks.add(new ForkJoinTest(work.substring(0, work.length()/2)));
		subtasks.add(new ForkJoinTest(work.substring(work.length()/2, work.length())));
		
		return subtasks;
	}

	private void process(String work) {
		System.out.print(work.toUpperCase());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		forkJoinPool.invoke(
				new ForkJoinTest("The invokeAll() method is the most convenient way to submit a sequence of ForkJoinTasks to the ForkJoinPool. It takes tasks as parameters (two tasks, var args, or a collection), forks them returns a collection of Future objects in the order in which they were produced.\r\n" + 
						"Alternatively, you can use separate fork() and join() methods. The fork() method submits a task to a pool, but it doesn’t trigger its execution. The join() method is be used for this purpose. In the case of RecursiveAction, the join() returns nothing but null; for RecursiveTask<V>, it returns the result of the task’s execution:\r\n" + 
						"2\r\n" + 
						"customRecursiveTaskFirst.fork();\r\n" + 
						"result = customRecursiveTaskLast.join();\r\n" + 
						"In our RecursiveTask<V> example we used the invokeAll() method to submit a sequence of subtasks to the pool. The same job can be done with fork() and join(), though this has consequences for the ordering of the results.\r\n" + 
						"To avoid confusion, it is generally a good idea to use invokeAll() method to submit more than one task to the ForkJoinPool."
						)
				);
		
	}

}
