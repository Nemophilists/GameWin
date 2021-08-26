package com.csi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;

public class GameWin extends JFrame {
    int weight=2*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    int height=4*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH;

    Image offSereenImage =null;

    MapButton mapButton=new MapButton();
    MapTop mapTop=new MapTop();

    void launch(){
        this.setVisible(true);
        this.setSize(weight,height);
        this.setLocationRelativeTo(null);
        this.setTitle("扫雷");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //鼠标事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1){
                   // System.out.println(1);记录坐标
                GameUtil.MOUSE_X=e.getX();
                GameUtil.MOUSE_Y=e.getY();
                GameUtil.LEFT=true;

                }
                if(e.getButton()==3){
                  //  System.out.println(3);
                    GameUtil.MOUSE_X=e.getX();
                    GameUtil.MOUSE_Y=e.getY();
                    GameUtil.RIGHT=true;

                }

            }
        });


        while (true)//时刻刷新
        {
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GameWin ga=new GameWin();
        ga.launch();
    }

    @Override
    public void paint(Graphics g) {
        offSereenImage =this.createImage(weight,height);
        Graphics gImage=offSereenImage.getGraphics();
        gImage.setColor(Color.green);//背景颜色
        gImage.fillRect(0,0,weight,height);
        mapButton.paintSetlf(gImage);
        mapTop.paintSetlf(gImage);
        g.drawImage(offSereenImage,0,0,null);

    }
}
