package net.sinou.java9.challenges.streams;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Play with the new {@code Spliterator} interface. Kindly provided
 * by @RafaDelNero
 */

public class DelNeroSplitChallenges {

	public static void main(String[] args) {
		challenge1();
	}

	private static void challenge1() {
		List<Animal> list = List.of(new Animal("Duck"), new Animal("Cat"), new Animal("Elephant"),
				new Animal("Dinosaur"), new Animal("Dog"));
		Stream<Animal> streamAnimal = StreamSupport.stream(new AnimalSpliterator(list.spliterator()), false);
		streamAnimal.forEach(a -> System.out.println(a.name));
	}

	static class Animal {
		private String name;

		public Animal(String name) {
			this.name = name;
		}
	}

	static class AnimalSpliterator implements Spliterator<Animal> {
		Spliterator<Animal> splitIterator;
		private String name;

		public AnimalSpliterator(Spliterator<Animal> spliterator) {
			this.splitIterator = spliterator;
		}

		public boolean tryAdvance(Consumer<? super Animal> action) {
			if (splitIterator.tryAdvance(l -> this.name = l.name)) {
				action.accept(new Animal(name));
				return false;
			} else
				return true;
		}

		@Override
		public int characteristics() {
			return splitIterator.characteristics();
		}

		@Override
		public long estimateSize() {
			return splitIterator.estimateSize() / 2;
		}

		@Override
		public Spliterator<Animal> trySplit() {
			return splitIterator.trySplit();
		}
	}
}
