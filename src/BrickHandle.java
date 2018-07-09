import javafx.scene.Group;
import javafx.stage.Stage;
import java.util.ArrayList;

public class BrickHandle {
    private static int col = 0;
    private ArrayList<ArrayList<Brick>>  bricks = new ArrayList<ArrayList<Brick>>();
    private static BrickHandle  brickHandle = new BrickHandle();
    private Stage st;


    public void makeBrick(Stage stage){
        st = stage;
        bricks.clear();
        col++;
        Brick temp = new Brick();
        int   number =(int)(stage.getScene().getWidth()/(temp.getWitdh()));
        for(int j =0;j<col;j++){
            bricks.add( new ArrayList<Brick>());
            for(int i=0;i<number;i++){
                Brick brick = new Brick(i*temp.getWitdh()+3*i,100+(j+1)*20+3*j);
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


}
