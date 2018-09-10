package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;



 class Item {

    private String name;
    private int qty;
    private BigDecimal price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Item(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	
    
}
public class CollectorsExample {

	public static void main(String[] args) {

		//Group by a List and display the total count of it
		List<String> items =
				Arrays.asList("apple", "apple", "banana",
						"apple", "orange", "orange", "orange", "orange", "banana", "papaya");

		Map<String, Long> result = 
				items.stream()
				.collect(
						Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(result);

		//Add sorting.
		
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
		.forEach(x -> System.out.println(x));
		
		
		
        //3 apple, 2 banana, others 1
        List<Item> items1 = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
		
		//Group by the name + Count or Sum the Qty.

        Map<String, Long> counting = items1.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));
        
        System.out.println(counting);

		
		//Group by Price – Collectors.groupingBy and Collectors.mapping example.
		
        Map<String, Integer> sum = items1.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        
        System.out.println(sum);

		//Group by Price – Collectors.groupingBy and Collectors.mapping example.
        
        Map<BigDecimal, Set<String>> result1 =
                items1.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );
        
        System.out.println(result1);
		
		
	}

}
