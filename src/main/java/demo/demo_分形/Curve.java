package main.java.demo.demo_分形;

import javax.swing.*;
import java.awt.*;

/**
 * Project:Exercise
 * Package:main.java.demo.demo_分形
 * Author:Alan Ruan
 * Date:2018-12-07 19:46
 * Description://TODO
 */
public class Curve extends JFrame {

    private String axiom;
    private String production;
    private String sequence;
    private Graphics gg;
    private int count;
    private double ra,rb;
    private Point[] points;

    public Curve(String axiom,int count)
    {
        this.axiom=axiom;
        this.count=count;
        production=axiom;
        this.setTitle("L-System");
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        gg = this.getGraphics();
    }

    @Override
    public void paint(Graphics g){
        //改写重绘方法
        super.paint(g);
        init();
        draw();
    }
    //	public void curve()
//	{
//		init();
//		draw();
//	}
    public void init()
    {
        //换算角度
        ra = 60*Math.PI/180;
        rb = 60*Math.PI/180;
        if(count==0)
        {
            sequence=axiom;
            return ;
        }
        sequence=axiom;
        //根据迭代次数生成新的正则表达式
        for(int i=0;i<count;i++)
        {
            StringBuffer buf = new StringBuffer();
//			System.out.println(sequence);
            for(int j = 0; j < sequence.length(); j++)
            {
                if(sequence.charAt(j) == 'F') {
                    buf.append(production);
                }
                else{
                    buf.append(sequence.charAt(j));
                }
            }
            sequence = buf.toString();
        }
//		System.out.println(sequence);
    }

    public void draw()
    {
        int n;
        //规定单位F的长度
        double len = 10;
        //设置方向向量
        double dx = 1,dy = 0;
        //设置起点坐标
        double x0 = 20,y0 = 500;
        double min_x,max_x,min_y,max_y;
        min_x=max_x=x0;
        min_y=max_y=y0;

        n = 1;
        for(int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'F') {
                n++;
            }
        }

        points = new Point[n];
        points[0] = new Point((int)x0,(int)y0);
        int num = 1;
        for(int i = 0; i < sequence.length(); i++)
        {
            if(sequence.charAt(i) == 'F')
            {
                double x1 = x0 + len*dx;
                double y1 = y0 + len*dy;
                x0 = x1;
                y0 = y1;
                if(x0 < min_x)
                {
                    min_x = x0;
                }
                if(x0 > max_x) {
                    max_x = x0;
                }
                if(y0 < min_y) {
                    min_y = y0;
                }
                if(y0 > max_y) {
                    max_y = y0;
                }
                points[num++] = new Point((int)x0,(int)y0);
            }else if(sequence.charAt(i) == '+')
            {
                //改变方向向量
                double _dx = dx*Math.cos(ra)-dy*Math.sin(ra);
                double _dy = dx*Math.sin(ra)+dy*Math.cos(ra);
                dx = _dx;
                dy = _dy;
            }else if(sequence.charAt(i) == '-')
            {
                double _dx = dx*Math.cos(-rb)-dy*Math.sin(-rb);
                double _dy = dx*Math.sin(-rb)+dy*Math.cos(-rb);
                dx = _dx;
                dy = _dy;
            }
        }

        int x1,x2,y1,y2;
        x2 = points[0].x;
        y2 = points[0].y;
        System.out.println(num);
        for(int i = 0; i < num; i++)
        {
            x1 = points[i].x;
            y1 = points[i].y;

            Graphics2D g2d = (Graphics2D) gg;
            g2d.setStroke(new BasicStroke(2));
            gg.drawLine(x2,y2,x1,y1);
            x2 = x1;
            y2 = y1;
        }
    }
}

