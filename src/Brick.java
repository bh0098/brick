
import javafx.scene.Group;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



import java.util.Random;
public class Brick implements Drawable {
        private double life =1;
        private double addPoint = 1;
        private double velocity;
        private Rectangle rectangle = new Rectangle(80,20);
        private Effect glow = new Glow(1);
        private Color color = Color.rgb(180 ,102,25);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Brick(){

        }
        public Brick(double x,double y){
        rectangle.setX(x);
        rectangle.setY(y);
        }

    public void draw(Stage stage) {
        rectangle.setFill(color);
        rectangle.setEffect(glow);
//        rectangle.setY(stage.getScene().getHeight() - 350);
//        rectangle.setX(90);
        ((Group)stage.getScene().getRoot()).getChildren().add(rectangle);
    }
        public Brick(double addPoint){
            this.addPoint = addPoint;
        }
        public void accident() { }
        public final double getAddPoint() {
            return addPoint;
        }
        public double getWitdh(){
            return rectangle.getWidth();
        }

//        public static Brick rand() {//in checkstyle gir midad majboor shodam statid konam
//            Random random = new Random();
//            switch (random.nextInt(6) + 1) {
//                case 1:
//                    return new AcceletorBrick();
//                case 2:
//                    return new MagicBrick();
//                case 3:
//                    return new QuickBrick();
//                case 4:
//                    return new SlownessBrick();
//
//                case 5:
//                    return new MagneticBrick();
//
//                case 6:
//                    return new SlowBrick();
//                default:
//                    return new Brick();
//
//            }
//        }


    public double getX (){
            return rectangle.getX();
    }
    public double getY(){
            return rectangle.getY();
    }
    public double getHeight(){
            return rectangle.getHeight();
    }
    public void setX(double x){
        rectangle.setX(x);
    }
    public void setY(double y){
        rectangle.setY(y);
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }
}


