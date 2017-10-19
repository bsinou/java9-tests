package net.sinou.java9.challenges.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Play with the new {@code Stream#collect()} method. Kindly provided
 * by @RafaDelNero
 */
public class DelNeroCollectorChallenges {

	public static void main(String[] args) {
		challenge1();
	}

	private static void challenge1() {
		Map<Integer, List<Integer>> map = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
				.collect(Collectors.groupingBy(i -> i % 2, Collectors.toList()));
		map.forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
