package com.csi;

import java.awt.*;

/**
 * 顶层地图类
 * 绘制顶层部件
 *  判断逻辑
 */
public class MapTop {

    int temp_x,temp_y;

    void spaceOpean(int x,int y){
        System.out.println(GameUtil.DATA_TOP[x][y]);
        if (GameUtil.DATA_BUTTONS[x][y] == 0) {

            for (int i = x-1; i <=x+1 ; i++) {
                for (int j = y-1; j <=y+1 ; j++) {
                    //覆盖递归
                    if (GameUtil.DATA_TOP[i][j] != -1) {
                        GameUtil.DATA_TOP[i][j]=-1;
                        //扩散至整个雷区
                        if(i>=1&&j>=1&&i<=GameUtil.MAP_W&&j<=GameUtil.MAP_H)
                        spaceOpean(i,j);
                    }

                }
            }

        }
    }

    void numOpen(int x,int y){
        //记录插旗数
        int count=0;
        if(GameUtil.DATA_BUTTONS[x][y]>0){
            for (int i = x-1; i <=x+1 ; i++) {
                for (int j = y-1; j <=y+1 ; j++) {
                    if(GameUtil.DATA_TOP[i][j]==1){
                        count++;
                    }
                }
            }
            if(count==GameUtil.DATA_BUTTONS[x][y]){
                for (int i = x-1; i <=x+1 ; i++) {
                    for (int j = y-1; j <=y+1 ; j++) {
                        //覆盖递归
                        if (GameUtil.DATA_TOP[i][j] != -1) {
                            GameUtil.DATA_TOP[i][j]=-1;
                            //扩散至整个雷区
                            if(i>=1&&j>=1&&i<=GameUtil.MAP_W&&j<=GameUtil.MAP_H)
                                numOpen(i,j);
                        }

                    }
                }

            }

        }
    }
    //判定是否失败
    boolean boom(){
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                if(GameUtil.DATA_BUTTONS[i][j]==-1&&GameUtil.DATA_TOP[i][j]==-1){
                    GameUtil.state=2;
                    setBoom();
                    return true;
                }
            }
        }
        return false;
    }

    //判定是否胜利
    boolean success(){
        int count=0;//设置一个统计量 统计未打开格子
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                if(GameUtil.DATA_TOP[i][j]!=-1){
                    count++;
                }
            }
        }
        if(count==GameUtil.RAY_MAX){
            //System.out.println("game success");
            GameUtil.state=1;
            for (int i = 1; i <= GameUtil.MAP_W; i++) {
                for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                    //未翻开的变成旗
                    if(GameUtil.DATA_TOP[i][j]==0){
                        GameUtil.DATA_TOP[i][j]=1;

                    }
                }
            }
            return true;
        }
        return false;
    }

    //判定失败后显示所有·雷
    void setBoom() {
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                //顶层·是雷不是旗
                if (GameUtil.DATA_BUTTONS[i][j] == -1 && GameUtil.DATA_TOP[i][j] != 1) {
                    GameUtil.DATA_TOP[i][j] = -1;
                }
                //顶层是旗 底层不是雷 显示错旗
                if (GameUtil.DATA_BUTTONS[i][j] != -1 && GameUtil.DATA_TOP[i][j] == 1) {
                    GameUtil.DATA_TOP[i][j] = 2;

                }
            }
        }
    }


    void logic(){
         temp_x=0;
         temp_y=0;
        if(GameUtil.MOUSE_X>GameUtil.OFFSET&&GameUtil.MOUSE_Y>3*GameUtil.OFFSET){
            temp_x=(GameUtil.MOUSE_X-GameUtil.OFFSET)/GameUtil.SQUARE_LENGTH+1;
            temp_y=(GameUtil.MOUSE_Y-GameUtil.OFFSET*3)/GameUtil.SQUARE_LENGTH+1;
        }

        if(temp_x>=1&&temp_x<=GameUtil.MAP_W&&temp_y>=1&&temp_y<=GameUtil.MAP_H ){
        if(GameUtil.LEFT){
                if(GameUtil.DATA_TOP[temp_x][temp_y]==0)
                {
                GameUtil.DATA_TOP[temp_x][temp_y]=-1;
                }
            spaceOpean(temp_x,temp_y);
            GameUtil.LEFT=false;
            }

            if(GameUtil.RIGHT)
            {
//            System.out.println(GameUtil.MOUSE_X);
//            System.out.println(GameUtil.MOUSE_Y);
                //覆盖则插旗
                if(GameUtil.DATA_TOP[temp_x][temp_y]==0)
                {
                    GameUtil.DATA_TOP[temp_x][temp_y]=1;
                }
                //已有则插旗取消
                else if(GameUtil.DATA_TOP[temp_x][temp_y]==1)
                {
                    GameUtil.DATA_TOP[temp_x][temp_y]=0;
                }
                else if (GameUtil.DATA_TOP[temp_x][temp_y]==-1)
                {
                numOpen(temp_x,temp_y);
                }
                GameUtil.RIGHT=false;
            }


            }
            boom();
        success();
        }


//        if(GameUtil.LEFT){
////            System.out.println(GameUtil.MOUSE_X);
////            System.out.println(GameUtil.MOUSE_Y);
//            GameUtil.LEFT=false;
//        }
//        if(GameUtil.RIGHT)
//        {
////            System.out.println(GameUtil.MOUSE_X);
////            System.out.println(GameUtil.MOUSE_Y);
//            GameUtil.RIGHT=false;
//        }



    void paintSetlf(Graphics g) {
        logic();
        g.setColor(Color.red);
//覆盖
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {

                if(GameUtil.DATA_TOP[i][j]==0){
                    g.drawImage(GameUtil.commit,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}

                if(GameUtil.DATA_TOP[i][j]==1){
                    g.drawImage(GameUtil.flag,
                            GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                            GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                            GameUtil.SQUARE_LENGTH+2,
                            GameUtil.SQUARE_LENGTH+2,
                            null);}
                if(GameUtil.DATA_TOP[i][j]==2){
                    g.drawImage(GameUtil.error,
                            GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                            GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                            GameUtil.SQUARE_LENGTH+2,
                            GameUtil.SQUARE_LENGTH+2,
                            null);}



            }
        }





    }



}
