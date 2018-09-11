package collection;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Even though Hashtable is thread safe, it is not very efficient. 
 * Another fully synchronized Map, Collections.synchronizedMap, does
 *  not exhibit great efficiency either. If we want thread-safety with high 
 *  throughput under high concurrency, these implementations aren’t the way to go.
 * 
Several default implementations are overridden, disabling the null key/value support:

getOrDefault
forEach
replaceAll
computeIfAbsent
computeIfPresent
compute
merge
The following APIs are also overridden to support atomicity, without a default interface implementation:

putIfAbsent
remove
replace(key, oldValue, newValue)
replace(key, value)
The rest of actions are directly inherited with basically consistent with Map.
 * */
public class ConcurrentMapExample {

	private static List<Integer> parallelSum100(Map<String, Integer> map, 
			int executionTimes) throws InterruptedException {
		List<Integer> sumList = new ArrayList<>(1000);
		for (int i = 0; i < executionTimes; i++) {
			map.put("test", 0);
			ExecutorService executorService = 
					Executors.newFixedThreadPool(4);
			for (int j = 0; j < 10; j++) {
				executorService.execute(() -> {
					for (int k = 0; k < 10; k++)
						map.computeIfPresent(
								"test", 
								(key, value) -> value + 1
								);
				});
			}
			executorService.shutdown();
			executorService.awaitTermination(5, TimeUnit.SECONDS);
			sumList.add(map.get("test"));
		}
		return sumList;
	}
	
	public static void main(String[] args) throws InterruptedException {

		//ConcurrentHashMap
		/*
		 * Before Java 8, the number of “segments” required was relative to the number of threads 
		 * accessing the table so that the update in progress per segment would be no more than 
		 * one most of time.
		 * However, since Java 8, the constructors are only present for backward compatibility: 
		 * the parameters can only affect the initial size of the map*/

		Map<String, Integer> map = new ConcurrentHashMap<>();
		List<Integer> sumList = parallelSum100(map, 100);

		/*System.out.println(sumList);
		 assertNotEquals(1, sumList
			      .stream()
			      .distinct()
			      .count());
			    long wrongResultCount = sumList
			      .stream()
			      .filter(num -> num != 100)
			      .count();
			     
			    assertTrue(wrongResultCount ==0);
			    */
		

	}

}
