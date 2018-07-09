import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Board implements Drawable,Moveable {
    private static Board board = new Board();
    private Rectangle rectangle = new Rectangle(110,10);
    private double velocity;
    private Board(){
        velocity = 10;
    }

    @Override
    public void move(Direct direct,Stage stage) {
        if(direct==Direct.RIGHT){
            if(rectangle.getX()<stage.getScene().getWidth() - rectangle.getWidth()){

                rectangle.setX(rectangle.getX()+velocity);
            }
        }else{
            if(rectangle.getX()>0){

                rectangle.setX(rectangle.getX()- velocity);
            }
        }
    }

    @Override
    public void draw(Stage stage) {
        rectangle.setFill(Color.GRAY);
        rectangle.setY(stage.getScene().getHeight() - 40);
        rectangle.setX(90);
        ((Group)stage.getScene().getRoot()).getChildren().add(rectangle);
    }


    public  static Board getInstance(){return board;}
    public double getHeight(){
        return rectangle.getY();
    }
    public Rectangle getRectangle(){
        return rectangle;
    }

}
