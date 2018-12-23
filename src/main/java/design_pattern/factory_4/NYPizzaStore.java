package design_pattern.factory_4;

/**
 * Project:Exercise
 * Package:main.java.design_pattern.factory_4
 * Author:Alan Ruan
 * Date:2018-09-22 17:38
 * Description://TODO
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {

        if (type != null){
            return new NYStylePizza(type);
        }else {
            return null;
        }

    }
}
