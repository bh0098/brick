import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application  {

    private KeyCode lastPressedKey;
    private Stage st;
    public void start(Stage primaryStage) throws Exception {
        st = primaryStage;
        Group root = new Group();
        Scene scene = new Scene(root,500,650);
        primaryStage.setScene(scene);

        background(primaryStage);

        brickManage(primaryStage);
        Ball.getInstance().draw(primaryStage);
        Board.getInstance().draw(primaryStage);

        keyPressHandle(scene,primaryStage);
        primaryStage.show();
    }


    public void keyPressHandle(Scene scene,Stage primaryStage){
        EventHandler<KeyEvent> keypress = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.RIGHT){
                    Board.getInstance().move(Moveable.Direct.RIGHT,primaryStage);
                }else if(event.getCode()==KeyCode.LEFT){
                    Board.getInstance().move(Moveable.Direct.LEFT,primaryStage);
                }
            }
        };
        scene.addEventHandler(KeyEvent.KEY_PRESSED, keypress);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), event -> {
            Ball.getInstance().move(Moveable.Direct.RIGHT,primaryStage);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    public void brickManage(Stage primaryStage){
        BrickHandle.getInstance().makeBrick(primaryStage);
    }

    public void background(Stage primaryStage)throws Exception{
        Image image = new Image(new FileInputStream("C:\\Users\\behnam\\Desktop\\BreakAndWall2\\src\\back.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(650);
        imageView.setFitWidth(500);
        ((Group)primaryStage.getScene().getRoot()).getChildren().add(imageView);
    }

    public Stage getStage(){
        return st;
    }
    public static void main(String[] args) {
        launch(args);
    }


}
