package net.sinou.java9.challenges.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/** Some interesting stream challenges to play with java 9 stream patterns */
public class DelNeroStreamChallenge {

	public static void main(String[] args) {
		challenge1();
		challenge2();
	}

	/** prints "Optional[12]" */
	private static void challenge1() {
		Optional<Integer> number = Stream.iterate(0, n -> n + 1).filter(DelNeroStreamChallenge::isEven)
				.filter(n -> n >= 5).map(n -> n * 2).limit(20).findAny();
		System.out.println(number);
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	/** prints "Optional.empty" */
	private static void challenge2() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		Optional<Integer> number = numbers.stream().filter(e -> e % 2 == 0).filter(e -> e >= 6).filter(e -> e > 6)
				.map(e -> e * 2).findFirst();
		System.out.println(number);
	}

}
