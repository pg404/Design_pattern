package design_pattern.decorator_3.starbuzz;

/**
 * Project: SomethingAboutJava
 * Package: design_pattern.decorator_3.starbuzz
 * Author: Alan Ruan
 * Date: 2019-03-13  15:28
 * Description: //TODO  抽象类
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
