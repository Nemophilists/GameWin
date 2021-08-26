package com.csi;

import java.lang.reflect.Method;

/*
* 初始化地雷
*
* */
public class BottomRay {
//    存放坐标-俩两为一个地雷坐标
    int[] rays=new int[GameUtil.RAY_MAX*2];
//    地雷坐标
    int x,y;

    {
        for (int i = 0; i < GameUtil.RAY_MAX*2; i+=2) {
            x= (int) (Math.random()*GameUtil.MAP_W+1);
            y= (int) (Math.random()*GameUtil.MAP_H+1);
            //    占位参数（用于解决地雷重合问题）
            boolean isPlace=true;
            //System.out.println("x:"+x+"y:"+y);
            //判断坐标是否存在
            for (int j = 0; j <i ; j=j+2) {

            if(x == rays[j] && y == rays[j+1]){
                i=i-2;//回退
                isPlace=false;        //不可放置
                break;
            }

            }
            //判断坐标是否可以放置
            if(isPlace)
            {
             rays[i]=x;
            rays[i+1]=y;

            }

        }
        for (int i = 0; i < GameUtil.RAY_MAX*2; i+=2) {
           GameUtil.DATA_BUTTONS[rays[i]][rays[i+1]]=-1;
        }
    }
}
