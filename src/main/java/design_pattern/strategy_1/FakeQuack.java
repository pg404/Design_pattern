package design_pattern.strategy_1;

public class FakeQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Qwak");
	}
}
