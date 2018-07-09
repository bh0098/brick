import javafx.scene.Group;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

public class BrickHandle {
    public final int numberOfBricksType = 2;
    private static int col = 0;
    private ArrayList<ArrayList<Brick>>  bricks = new ArrayList<ArrayList<Brick>>();
    private static BrickHandle  brickHandle = new BrickHandle();
    private Stage st;
    private ArrayList<Brick> bricksType = new ArrayList<>();


    public void makeBrick(Stage stage){
        startBricksType();
        st = stage;
        bricks.clear();
        col++;
        Brick temp = new Brick();
        int   number =(int)(stage.getScene().getWidth()/(temp.getWitdh()));
        for(int j =0;j<col;j++){
            bricks.add( new ArrayList<Brick>());
            for(int i=0;i<number;i++){
                Brick brick = randomBrick();
                brick.setX(i*temp.getWitdh()+3*i);
                brick.setY(100+(j+1)*20+3*j);
                brick.draw(stage);
                bricks.get(j).add(brick);
            }
        }
    }
    private BrickHandle(){}


    public static BrickHandle getInstance(){return brickHandle;}

    public ArrayList<ArrayList<Brick>> getBricks(){
        return bricks;
    }
    public void remove(Brick brick){
        ((Group) st.getScene().getRoot()).getChildren().remove(brick);
    }

    public Brick randomBrick(){
        Random random = new Random();
        int rand = random.nextInt(bricksType.size());
//        return bricksType.get(rand);
        switch(rand){
            case 0:
                return new QuickBrick();
            case 1:
                return new Brick();
            case 2:
                return new SlowBrick();
            default :
                return new Brick();
        }
    }
    public void startBricksType(){
        bricksType.add(new Brick());
        bricksType.add(new QuickBrick());
        bricksType.add(new SlowBrick());
    }


}
