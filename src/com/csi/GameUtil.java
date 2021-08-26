package com.csi;

import javax.swing.plaf.nimbus.State;
import java.awt.*;

/*
* 工具类
* 存放静态参数
* 工具方法
* */
public class GameUtil {

    //地雷个数
    static int RAY_MAX=5;
    //地图的宽
    static int MAP_W=11;
    //地图的高
    static int MAP_H=11;

    //雷区偏移量
    static int OFFSET=45;

    //格子长
    static int SQUARE_LENGTH=50;

    //鼠标相关参数
    //1-坐标
    static int MOUSE_X;
    static int MOUSE_Y;
    //2-状态
    static boolean LEFT=false;

    static boolean RIGHT=false;

    //游戏状态 0为在游戏中 1为胜利 2为失败
    static int state=0;

    //数组中存放底层元素 1为雷 0为空 1-8代表对应数字
    static int[][]DATA_BUTTONS=new int[MAP_W+2][MAP_H+2];
    //数组中存放顶层元素 -1 无覆盖 0覆盖 1插旗 2插旗错误
    static int[][]DATA_TOP=new int[MAP_W+2][MAP_H+2];

    //载入图片
    static Image lei=Toolkit.getDefaultToolkit().getImage("imgs/lei.png");

    static Image one=Toolkit.getDefaultToolkit().getImage("imgs/one.png");

    static Image two=Toolkit.getDefaultToolkit().getImage("imgs/two.png");

    static Image three=Toolkit.getDefaultToolkit().getImage("imgs/three.png");

    static Image four=Toolkit.getDefaultToolkit().getImage("imgs/four.png");

    static Image five=Toolkit.getDefaultToolkit().getImage("imgs/five.png");

    static Image six=Toolkit.getDefaultToolkit().getImage("imgs/six.png");

    static Image seven=Toolkit.getDefaultToolkit().getImage("imgs/seven.png");

    static Image eigth=Toolkit.getDefaultToolkit().getImage("imgs/eigth.png");

    static Image flag=Toolkit.getDefaultToolkit().getImage("imgs/flag.png");

    static Image success=Toolkit.getDefaultToolkit().getImage("imgs/success.png");

    static Image ing=Toolkit.getDefaultToolkit().getImage("imgs/ing.png");

    static Image boom=Toolkit.getDefaultToolkit().getImage("imgs/boom.png");

    static Image commit=Toolkit.getDefaultToolkit().getImage("imgs/commit.png");

    static Image error=Toolkit.getDefaultToolkit().getImage("imgs/error.png");



}
