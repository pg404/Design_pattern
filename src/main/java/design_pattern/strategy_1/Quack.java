package design_pattern.strategy_1;

public class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Quack");
	}
}
