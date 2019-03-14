package design_pattern.strategy_1;

public class FlyNoWay implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("I can't fly");
	}
}
