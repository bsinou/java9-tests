package net.sinou.java9.challenges.optionals;

import java.util.Optional;

/** Optional challenges kindly provided by @RafaDelNero */
public class DeNeroOptionalChallenges {

	public static void main(String[] args) {
		challenge1();
	}

	private static void challenge1() {
		Optional<Warrior> optWarrior = Warrior.getWarrior();
		Optional<Warrior> sw = getEmpty().or(() -> Warrior.getWarrior()).or(() -> optWarrior);
		System.out.println(sw.get().name);
	}

	static Optional<Warrior> getEmpty() {
		return Optional.empty();
	}

	static class Warrior {
		private String name;

		Warrior(String name) {
			this.name = name;
		}

		static Optional<Warrior> getWarrior() {
			return Optional.of(new Warrior("Kratos"));
		}
	}
}
