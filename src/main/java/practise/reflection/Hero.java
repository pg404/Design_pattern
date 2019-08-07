package practise.reflection;

/**
 * Project: SomethingAboutJava
 * Package: practise.reflection
 * Author: Alan Ruan
 * Date: 2019-03-22  17:21
 * Description: //TODO
 */
public class Hero {

    public String name;
    public float hp;
    public int damage;
    public int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static String copyright;

    static {
        System.out.println("初始化 copyright");
        copyright = "版权由Alan Ruan所有";
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                ", id=" + id +
                '}';
    }
}
