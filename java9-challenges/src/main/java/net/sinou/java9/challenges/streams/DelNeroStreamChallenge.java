package net.sinou.java9.challenges.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Some interesting stream challenges to play with java 9 stream patterns kindly
 * provided by @RafaDelNero
 */
public class DelNeroStreamChallenge {

	public static void main(String[] args) {
		challenge1();
		challenge2();
		challenge3();
	}

	/** Prints "Optional[12]" */
	private static void challenge1() {
		Optional<Integer> number = Stream.iterate(0, n -> n + 1).filter(DelNeroStreamChallenge::isEven)
				.filter(n -> n >= 5).map(n -> n * 2).limit(20).findAny();
		System.out.println(number);
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	/** Prints "Optional.empty" */
	private static void challenge2() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		Optional<Integer> number = numbers.stream().filter(e -> e % 2 == 0).filter(e -> e >= 6).filter(e -> e > 6)
				.map(e -> e * 2).findFirst();
		System.out.println(number);
	}

	/**
	 * Prints nothing. Added a few more statements for further understanding: the
	 * initial string is not split and all assertions are made on the full string
	 */
	private static void challenge3() {
		String ss = "<Tony,Junior,Christopher>";
		// This does not print anything
		Stream.of(ss).dropWhile(s -> !s.contains("<")).takeWhile(s -> !s.contains(">")).forEach(System.out::println);

		// To further check
		Stream.of(ss).forEach(System.out::println);
		System.out.println(Stream.of(ss).count());
	}

}
