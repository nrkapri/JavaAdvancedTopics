package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Hosting {

	private int Id;
	private String name;
	private long websites;

	public Hosting(int id, String name, long websites) {
		Id = id;
		this.name = name;
		this.websites = websites;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWebsites() {
		return websites;
	}

	public void setWebsites(long websites) {
		this.websites = websites;
	}

	//getters, setters and toString()
}

public class StreamandMapExample {


	public static void main(String[] args) {

		/*
		 * Convert a Map into a Stream
		 * Sort it
		 * Collect and return a new LinkedHashMap (keep the order)
		 * */

		Map<String, Integer> unsortMap = new HashMap<>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("g", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);

		//sort by key
		Map<String, Integer> result = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		System.out.println(result);

		//sort by valeuss
		Map<String, Integer> result1 = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		System.out.println(result1);



		//List to Map

		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));

		// key = id, value - websites
		Map<Integer, String> result2 = list.stream().collect(
				Collectors.toMap(Hosting::getId, Hosting::getName));

		System.out.println("Result 2 : " + result2);


		// key = name, value - websites
		Map<String, Long> result3 = list.stream().collect(
				Collectors.toMap(Hosting::getName, Hosting::getWebsites));

		System.out.println("Result 3 : " + result3);

		list.add(new Hosting(6, "linode.com", 100000)); // new line

		// key = name, value - websites , but the key 'linode' is duplicated!?
		Map<String, Long> result4 = list.stream().collect(
				Collectors.toMap(Hosting::getName, Hosting::getWebsites, (o,n)-> n));

		System.out.println(result4);


		//sort and collect 

		Map result5 = list.stream()
				.sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
				.collect(
						Collectors.toMap(
								Hosting::getName, Hosting::getWebsites, // key = name, value = websites
								(oldValue, newValue) -> newValue,       // if same key, take the old key
								LinkedHashMap::new                      // returns a LinkedHashMap, keep order
								));

		System.out.println(result5);



		//Filter Map example 
		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");
		//convert a Map.entrySet() into a stream, follow by a filter() and collect() it.

		String results = "";
		results = HOSTING.entrySet().stream()
				.filter(map -> "aws.amazon.com".equals(map.getValue()))
				.map(map -> map.getValue())
				.collect(Collectors.joining());

		System.out.println("With Java 8 : " + results);


		String results1 = "";
		results1 = HOSTING.entrySet().stream()
				.filter(
						(x)->{
							return 	x.getValue().contains("aws") || x.getValue().contains("her");
						}
						)
				.map(m ->m.getValue())
				.collect(Collectors.joining(","));

		System.out.println(results1);
		
		
		//filter a Map by key,  return a Map
		Map<Integer, String> collect2 = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() <= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(collect2);
		
		
	}

}
