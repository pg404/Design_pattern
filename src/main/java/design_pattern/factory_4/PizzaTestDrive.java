package main.java.design_pattern.factory_4;

/**
 * Project:Exercise
 * Package:main.java.design_pattern.factory_4
 * Author:Alan Ruan
 * Date:2018-09-22 17:55
 * Description://TODO
 */
public class PizzaTestDrive {

    public static void main(String[] args){
        PizzaStore ny = new NYPizzaStore();

        Pizza pizza = new NYStylePizza("cheese");


    }


}
