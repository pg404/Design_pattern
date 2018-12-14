package main.java.demo.demo_分形;

/**
 * Project:Exercise
 * Package:main.java.demo.demo_分形
 * Author:Alan Ruan
 * Date:2018-12-07 19:49
 * Description://TODO
 */
public class Manager
{
    public static void main(String[] args)
    {
        Manager mag=new Manager();
        mag.Draw();
    }

    public void Draw()
    {
        String axiom="F-F++F-F";//母串
        int count=3;//表示迭代的次数
        Curve curve=new Curve(axiom,count);

//		 try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		 curve.init();
//		 curve.draw();
//		 curve.curve();
        curve.paint(curve.getGraphics());
    }
}
