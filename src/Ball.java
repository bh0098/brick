import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Ball implements Moveable, Drawable {
    public static final double ballX = 150;
    public static final double ballY = 350;
    private       Text text = new Text();
    private double score = 0;
    private static Ball ball = new Ball();
    private double x = 50;
    private double y = 300;
    private final double RADIUS = 5;
    private double velocityY = 3;
    private double velocityX = 2;
    private Circle circle;
    private int level=1;

    private Ball() {
        circle = new Circle(x, y, RADIUS);
    }

    @Override
    public void move(Direct direct, Stage stage) {
        if (circle.getCenterX() > stage.getScene().getWidth() - circle.getRadius() || circle.getCenterX() < circle.getRadius()) {
            velocityX *= -1;
        }
        if (circle.getCenterY() > Board.getInstance().getRectangle().getY() - circle.getRadius()) {
            if ((circle.getCenterX() > Board.getInstance().getRectangle().getX()) &&
                    circle.getCenterX() < Board.getInstance().getRectangle().getX() + Board.getInstance().getRectangle().getWidth()) {
                velocityY *= -1;
            } else {
                System.out.println("you lost");
                stage.close();
            }

        }
        if (circle.getCenterY() - circle.getRadius() < 0) {
            velocityY *= -1;
        }
//        if(((Rectangle)Board.getInstance().getRectangle())
//                .getBoundsInParent().contains(circle.getCenterX(),circle.getCenterY())){
//            velocityY*=-1;
//        }
//        Shape intersect = Shape.intersect(circle, Board.getInstance().getRectangle());
//        if(intersect.getBoundsInParent().getWidth()>0){
//            velocityY*=-1;
//        }

        collosion(stage);

        circle.setCenterX(circle.getCenterX() + velocityX);
        circle.setCenterY(circle.getCenterY() + velocityY);

    }

    @Override
    public void draw(Stage stage) throws Exception {
        circle.setFill(Color.rgb(236, 20, 45));
        ((Group) stage.getScene().getRoot()).getChildren().add(circle);
    }

    public static Ball getInstance() {
        return ball;
    }

    public void collosion(Stage stage) {
        boolean isEnd =true;
        Brick temp =  null;
        for(int i=0;i<BrickHandle.getInstance().getBricks().size();i++){
            for(int j=0;j<(BrickHandle.getInstance().getBricks()).get(i).size();j++){
                Brick list = ((BrickHandle.getInstance().getBricks()).get(i)).get(j);
                if (circle.getCenterX() + circle.getRadius() < list.getX() + list.getWitdh() && circle.getCenterX() + circle.getRadius() > list.getX()) {
                    if (circle.getCenterY() - circle.getRadius() > list.getY() && circle.getCenterY() - circle.getRadius() < list.getY() + list.getHeight()) {
                        score+=list.getAddPoint();
                        scoreBoard(stage);
                        velocityY *= -1;
                        list.setLife(list.getLife() - 1);
                        if (list.getLife() == 0) {
                            ((Group) stage.getScene().getRoot()).getChildren().remove(list);
                            BrickHandle.getInstance().remove(list);
                            BrickHandle.getInstance().getBricks().get(i).remove(list);
                        }
                    }
                }
                isEnd=false;
            }
        }
//        for (ArrayList<Brick> arrayList : BrickHandle.getInstance().getBricks()) {
//            for (Brick list : arrayList) {
//
//
//            }
//        }
        if (isEnd) {
            level++;
            System.out.println("level up");
            circle.setCenterX(ballX);
            circle.setCenterY(ballY);
//            Text t= new Text("LEVEL "+(Integer)level);
//            t.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,50));
//            t.setX(stage.getScene().getWidth()-60);
//            t.setY(40);
//            t.setFill(Color.BLANCHEDALMOND);
            //make delay
            BrickHandle.getInstance().makeBrick(stage);
        }
    }

    public double getScore() {
        return score;
    }
    public void scoreBoard(Stage stage){
        ((Group)stage.getScene().getRoot()).getChildren().remove(text);
        text.setText(((Double)Ball.getInstance().getScore()).toString());
        text.setX(stage.getScene().getWidth()-60);
        text.setY(40);
        text.setFill(Color.BLANCHEDALMOND);
        text.setStroke(Color.BLUE);
        text.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,25));
        ((Group)stage.getScene().getRoot()).getChildren().add(text);

    }
}
