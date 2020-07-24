import java.awt.*;
import java.sql.Time;
import java.util.Random;
import java.util.Scanner;

public class GameOfLifeMain {

    int[][] setOfCells;
    int height=2, width=2,maxDensity=6,midDensity=4,minDensity=2;
    GameInterface gameInterface;

    public static void main(String[] args){

        GameOfLifeMain gameOfLifeMain=new GameOfLifeMain();
        gameOfLifeMain.init();
        while (true){
            gameOfLifeMain.run();
        }
    }

    public void init(){//初始化
        Scanner scanner=new Scanner(System.in);
        System.out.println("游戏世界的高度？<建议100>");
        height=scanner.nextInt();
        System.out.println("游戏世界的宽度？<建议100>");
        width=scanner.nextInt();
        System.out.println("最大密度？(周围数目大于等于多少时会死亡)<建议4>");
        maxDensity=scanner.nextInt();
        System.out.println("稳定点？(数目在稳定点以下时，状态不变，大于等于稳定点时会出生)<建议3>");
        midDensity=scanner.nextInt();
        System.out.println("最小密度？(周围数目小于等于多少时会死亡)<建议1>");
        minDensity=scanner.nextInt();
        gameInterface=new GameInterface(height,width);
        Random random=new Random();//随机生成世界

        setOfCells=new int[height][width];//初始化细胞群
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++) {
                //setOfCells[i][j] = random.nextBoolean()?1:0;
                setOfCells[i][j] = random.nextFloat()>0.5?1:0;
            }
        }
        gameInterface.refresh(setOfCells,height,width);



    }

    public void run(){

        int[][] copyOfSetOfCells=new int[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++) {
                copyOfSetOfCells[i][j]=setOfCells[i][j];
            }
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++) {
                int count=0;
                if(i==0&&j==0){//左上角
                    if(setOfCells[i][j+1]==1){
                        count++;
                    }
                    if(setOfCells[i+1][j]==1){
                        count++;
                    }
                    if(setOfCells[i+1][j+1]==1){
                        count++;
                    }
                    if(count>=maxDensity||count<=minDensity){
                        copyOfSetOfCells[i][j]=0;
                    }else if(count<maxDensity&&count>=midDensity){
                        copyOfSetOfCells[i][j]=1;
                    }else if(count<midDensity&&count>minDensity){
                        //状态不变
                    }
                    continue;
                }
                if(i==0&&j!=0&&j!=width-1){//上边
                    if(setOfCells[i][j-1]==1){//左
                        count++;
                    }
                    if(setOfCells[i][j+1]==1){//右
                        count++;
                    }
                    if(setOfCells[i+1][j-1]==1){//左下
                        count++;
                    }
                    if(setOfCells[i+1][j]==1){//下
                        count++;
                    }
                    if(setOfCells[i+1][j+1]==1){//右下
                        count++;
                    }
                    if(count>=maxDensity||count<=minDensity){
                        copyOfSetOfCells[i][j]=0;
                    }else if(count<maxDensity&&count>=midDensity){
                        copyOfSetOfCells[i][j]=1;
                    }else if(count<midDensity&&count>minDensity){
                        //状态不变
                    }
                    continue;
                }
                if(i==0&&j==width-1){//右上角
                    if(setOfCells[i][j-1]==1){//左
                        count++;
                    }
                    if(setOfCells[i+1][j-1]==1){//左下
                        count++;
                    }
                    if(setOfCells[i+1][j]==1){//下
                        count++;
                    }
                    if(count>=maxDensity||count<=minDensity){
                        copyOfSetOfCells[i][j]=0;
                    }else if(count<maxDensity&&count>=midDensity){
                        copyOfSetOfCells[i][j]=1;
                    }else if(count<midDensity&&count>minDensity){
                        //状态不变
                    }
                    continue;
                }
                if(j==0&&i!=0&&i!=height-1){//左边
                    if(setOfCells[i-1][j]==1){//上
                        count++;
                    }
                    if(setOfCells[i-1][j+1]==1){//右上
                        count++;
                    }
                    if(setOfCells[i][j+1]==1){//右
                        count++;
                    }
                    if(setOfCells[i+1][j]==1){//下
                        count++;
                    }
                    if(setOfCells[i+1][j+1]==1){//右下
                        count++;
                    }
                    if(count>=maxDensity||count<=minDensity){
                        copyOfSetOfCells[i][j]=0;
                    }else if(count<maxDensity&&count>=midDensity){
                        copyOfSetOfCells[i][j]=1;
                    }else if(count<midDensity&&count>minDensity){
                        //状态不变
                    }
                    continue;
                }
                if(j==width-1&&i!=0&&i!=height-1){//右边
                    if(setOfCells[i-1][j-1]==1){//左上
                        count++;
                    }
                    if(setOfCells[i-1][j]==1){//上
                        count++;
                    }
                    if(setOfCells[i][j-1]==1){//左
                        count++;
                    }
                    if(setOfCells[i+1][j-1]==1){//左下
                        count++;
                    }
                    if(setOfCells[i+1][j]==1){//下
                        count++;
                    }
                    if(count>=maxDensity||count<=minDensity){
                        copyOfSetOfCells[i][j]=0;
                    }else if(count<maxDensity&&count>=midDensity){
                        copyOfSetOfCells[i][j]=1;
                    }else if(count<midDensity&&count>minDensity){
                        //状态不变
                    }
                    continue;
                }
                if(i==height-1&&j==0){//左下角
                    if(setOfCells[i-1][j]==1){//上
                        count++;
                    }
                    if(setOfCells[i-1][j+1]==1){//右上
                        count++;
                    }
                    if(setOfCells[i][j+1]==1){//右
                        count++;
                    }
                    if(count>=maxDensity||count<=minDensity){
                        copyOfSetOfCells[i][j]=0;
                    }else if(count<maxDensity&&count>=midDensity){
                        copyOfSetOfCells[i][j]=1;
                    }else if(count<midDensity&&count>minDensity){
                        //状态不变
                    }
                    continue;
                }
                if(i==height-1&&j!=0&&j!=width-1){//下边
                    if(setOfCells[i-1][j-1]==1){//左上
                        count++;
                    }
                    if(setOfCells[i-1][j]==1){//上
                        count++;
                    }
                    if(setOfCells[i-1][j+1]==1){//右上
                        count++;
                    }
                    if(setOfCells[i][j-1]==1){//左
                        count++;
                    }
                    if(setOfCells[i][j+1]==1){//右
                        count++;
                    }
                    if(count>=maxDensity||count<=minDensity){
                        copyOfSetOfCells[i][j]=0;
                    }else if(count<maxDensity&&count>=midDensity){
                        copyOfSetOfCells[i][j]=1;
                    }else if(count<midDensity&&count>minDensity){
                        //状态不变
                    }
                    continue;
                }
                if(i==height-1&&j==width-1){//右下角
                    if(setOfCells[i-1][j-1]==1){//左上
                        count++;
                    }
                    if(setOfCells[i-1][j]==1){//上
                        count++;
                    }
                    if(setOfCells[i][j-1]==1){//左
                        count++;
                    }
                    if(count>=maxDensity||count<=minDensity){
                        copyOfSetOfCells[i][j]=0;
                    }else if(count<maxDensity&&count>=midDensity){
                        copyOfSetOfCells[i][j]=1;
                    }else if(count<midDensity&&count>minDensity){
                        //状态不变
                    }
                    continue;
                }

                if(setOfCells[i-1][j-1]==1){//左上
                    count++;
                }
                if(setOfCells[i-1][j]==1){//上
                    count++;
                }
                if(setOfCells[i-1][j+1]==1){//右上
                    count++;
                }
                if(setOfCells[i][j-1]==1){//左
                    count++;
                }
                if(setOfCells[i][j+1]==1){//右
                    count++;
                }
                if(setOfCells[i+1][j-1]==1){//左下
                    count++;
                }
                if(setOfCells[i+1][j]==1){//下
                    count++;
                }
                if(setOfCells[i+1][j+1]==1){//右下
                    count++;
                }
                if(count>=maxDensity||count<=minDensity){
                    copyOfSetOfCells[i][j]=0;
                }else if(count<maxDensity&&count>=midDensity){
                    copyOfSetOfCells[i][j]=1;
                }else if(count<midDensity&&count>minDensity){
                    //状态不变
                }

            }
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++) {
                setOfCells[i][j]=copyOfSetOfCells[i][j];
            }
        }
        gameInterface.refresh(setOfCells,height,width);
        Robot robot= null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(100);

    }
}
