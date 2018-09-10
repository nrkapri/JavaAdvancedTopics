package java8;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {

		//Basic
		Optional<String> gender = Optional.of("MALE");
		System.out.println("Non-Empty Optional:" + gender);
		System.out.println("Non-Empty Optional: Gender value : " + gender.get());
		System.out.println("Empty Optional: " + Optional.empty());

		String answer1 = "Yes";
		String answer2 = null;
		System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
		System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));


		// java.lang.NullPointerException
		//System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));

		//Optional.map and flatMap
		Optional<String> nonEmptyGender = Optional.of("male");
		Optional<String> emptyGender = Optional.empty();

		System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
		System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

		Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
		System.out.println("Optional value   :: " + nonEmptyOtionalGender);
		System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(g -> g.map(String::toUpperCase)));
		System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(g -> g.map(String::toUpperCase)));

		//Filter on Optional
		System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
		System.out.println(gender.filter(g -> g.equals("MALE"))); //Optional[MALE]
		System.out.println(emptyGender.filter(g -> g.equals("MALE"))); //Optional.empty

		//Optional isPresent and ifPresent
		if (gender.isPresent()) {
			System.out.println("Value available.");
		} else {
			System.out.println("Value not available.");
		}

		gender.ifPresent(g -> System.out.println("In gender Option, value available."));

		//condition failed, no output print
		emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));

		//Optional orElse methods
		System.out.println(gender.orElse("<N/A>")); //MALE
		System.out.println(emptyGender.orElse("<N/A>")); //<N/A>

		System.out.println(gender.orElseGet(() -> "<N/A>")); //MALE
		System.out.println(emptyGender.orElseGet(() -> "<N/A>")); //<N/A>

		//Where does Java Optional fits?
		/*
		 * 8.1 Method Parameter
        public void setResolution(Optional<ScreenResolution> resolution) {
        	this.resolution = resolution;
        }

		8.2 Method Return Type
        public Optional<ScreenResolution> getResolution() {
			return resolution;
		}
		
		8.3 Constructor Parameter
		
		public DisplayFeatures(String size, Optional<ScreenResolution> resolution){
			this.size = size;
			this.resolution = resolution;
		}
		
		
		8.4 Variable Declaration
		
		private Optional<ScreenResolution> resolution;
		
		8.5 Class Level
		
		public class B

		public class A<T extends Optional<B>> { }
		
		



		 */

	}

}
