package com.csi;
/**
 * 底层数字类
 * 用于显示地雷旁边的数字
*/
public class ButtomNum {
    {
        for (int i = 1; i <=GameUtil.MAP_W; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                if(GameUtil.DATA_BUTTONS[i][j]==-1)//判断是否有雷
                {//有的话遍历一个3*3得数组
                    for (int k = i-1; k <=i+1 ; k++) {
                        for (int l = j-1; l <=j+1 ; l++) {
                            if(GameUtil.DATA_BUTTONS[k][l]>=0)
                                GameUtil.DATA_BUTTONS[k][l] ++;

                        }
                    }
                    
                }
            }
        }

    }
}
