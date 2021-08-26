package com.csi;


import java.awt.*;

/*
* 底层地图绘制
*游戏相关组件
* */
public class MapButton {

    BottomRay bottomRay=new BottomRay();
    ButtomNum buttomNum=new ButtomNum();
    void paintSetlf(Graphics g) {
        g.setColor(Color.red);

//竖线
        for (int i = 0; i <= GameUtil.MAP_W; i++) {
            g.drawLine(GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET,
                    GameUtil.OFFSET + GameUtil.SQUARE_LENGTH* i ,
                    3 * GameUtil.OFFSET + GameUtil.MAP_H * GameUtil.SQUARE_LENGTH
            );
        }
//横线
        for (int i = 0; i <= GameUtil.MAP_H; i++) {
            g.drawLine(GameUtil.OFFSET,
                    3 * GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    GameUtil.OFFSET + GameUtil.SQUARE_LENGTH * GameUtil.MAP_W,
                    3 * GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH
            );
        }

        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {

                if(GameUtil.DATA_BUTTONS[i][j]==-1){g.drawImage(GameUtil.lei,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}

                if(GameUtil.DATA_BUTTONS[i][j]==1){g.drawImage(GameUtil.one,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}
                if(GameUtil.DATA_BUTTONS[i][j]==2){g.drawImage(GameUtil.two,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}
                if(GameUtil.DATA_BUTTONS[i][j]==3){g.drawImage(GameUtil.three,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}
                if(GameUtil.DATA_BUTTONS[i][j]==4){g.drawImage(GameUtil.four,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}
                if(GameUtil.DATA_BUTTONS[i][j]==5){g.drawImage(GameUtil.five,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}
                if(GameUtil.DATA_BUTTONS[i][j]==6){g.drawImage(GameUtil.six,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}
                if(GameUtil.DATA_BUTTONS[i][j]==7){g.drawImage(GameUtil.seven,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}
                if(GameUtil.DATA_BUTTONS[i][j]==8){g.drawImage(GameUtil.eigth,
                        GameUtil.OFFSET+(i-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.OFFSET*3+(j-1)*GameUtil.SQUARE_LENGTH+1,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);}


            }
        }

        switch (GameUtil.state){
            case 0:
                g.drawImage(GameUtil.ing,
                    GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                    null);
                break;
            case 1:
                g.drawImage(GameUtil.success,
                        GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);
                break;
            case 2:
                g.drawImage(GameUtil.six,
                        GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        GameUtil.SQUARE_LENGTH+2,
                        GameUtil.SQUARE_LENGTH+2,
                        null);
                break;
            default:

        }

    }
}
