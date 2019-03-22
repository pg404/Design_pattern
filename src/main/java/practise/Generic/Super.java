package practise.Generic;

import practise.IO.Hero;

import java.util.ArrayList;

/**
 * Project: SomethingAboutJava
 * Package: practise.Generic
 * Author: Alan Ruan
 * Date: 2019-03-22  13:49
 * Description: //TODO ArrayList heroList<? super Hero> 表示这是一个Hero泛型或者其父类泛型
 * heroList的泛型可能是Hero
 * heroList的泛型可能是Object
 *
 * 可以往里面插入Hero以及Hero的子类
 * 但是取出来有风险，因为不确定取出来是Hero还是Object
 *
 *
 */
public class Super {

    public static void main(String[] args) {

        ArrayList<? super Hero> heroList = new ArrayList<Object>();

        //? super Hero 表示 heroList的泛型是Hero或者其父类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以是Object

        //所以就可以插入Hero
        heroList.add(new Hero());
        //也可以插入Hero的子类
//        heroList.add(new APHero());
//        heroList.add(new ADHero());

        //但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Hero会失败
//        Hero h= heroList.get(0);


    }

    /*
    * 泛型通配符? 代表任意泛型
既然?代表任意泛型，那么换句话说，这个容器什么泛型都有可能

所以只能以Object的形式取出来
并且不能往里面放对象，因为不知道到底是一个什么泛型的容器
    * */


    /*
    子类泛型不可以转换为父类泛型
    * */




}
