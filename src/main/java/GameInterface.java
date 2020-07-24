import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameInterface {

    JFrame jFrame;
    JPanel jPanel;
    JLabel[][] jLabels;

    GameInterface(int height,int width){
        jFrame=new JFrame();//主框架
        jPanel=new JPanel();
        jLabels=new JLabel[height][width];
        //ImageIcon imageIcon=new ImageIcon("like.png");

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){//初始化每个小格子的内容
                jLabels[i][j]=new JLabel();
                jLabels[i][j].setOpaque(true);

                jLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);//标签内容居中
                jLabels[i][j].setVerticalAlignment(SwingConstants.CENTER);

                jLabels[i][j].setBorder(BorderFactory.createLineBorder(Color.black));//标签边框

                jPanel.add(jLabels[i][j]);//将label添加到panel中
            }
            jPanel.setLayout(new GridLayout(height,width,0,0));
        }

        jFrame.add(jPanel);
        jFrame.setSize(1000,1000);
        jFrame.setResizable(false);
        jFrame.setUndecorated(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void go(){

    }

    public void refresh(int setOfCells[][],int height,int width){
        for(int i=0;i<height;i++) {
            for (int j = 0; j < width; j++) {
                if(setOfCells[i][j]==1){
                    jLabels[i][j].setBackground(Color.black);
                }else {
                    jLabels[i][j].setBackground(Color.white);
                }
            }
        }
    }
}
