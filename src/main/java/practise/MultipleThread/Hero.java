package practise.MultipleThread;

/**
 * Project: SomethingAboutJava
 * Package: practise.MultipleThread
 * Author: Alan Ruan
 * Date: 2019-03-22  14:34
 * Description: //TODO
 */
public class Hero {

    public String name;
    public float hp;

    public int damage;

    public synchronized void recover(){
        hp=hp+1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        if (hp > 10)
        // 通知那些等待在this对象上的线程，可以醒过来了
        {
            this.notify();
        }
    }

    public synchronized void hurt(){
        if (hp == 1) {
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        hp=hp-1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
    }

    public void attackHero(Hero h){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if (h.isDead()){
            System.out.println(h.name +"死了！");
        }
    }

    public boolean isDead() {
        return 0 >= hp ? true:false;
    }


}
