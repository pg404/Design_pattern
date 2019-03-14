package design_pattern.templatemethod_8.barista;

public class Coffee extends CaffeineBeverage {
	@Override
	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}
	@Override
	public void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}
}
