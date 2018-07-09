import javafx.scene.paint.Color;
public class SlowBrick extends Brick implements Drawable {


    SlowBrick() {
        super();
        super.setColor(Color.rgb(200, 21, 150));
    }

    @Override
    public void accident() {
        if(Ball.getInstance().getVelocityX()>2&&Ball.getInstance().getVelocityY()>2){
            Ball.getInstance().setVelocityY(Ball.getInstance().getVelocityY() - 2);
            Ball.getInstance().setVelocityX(Ball.getInstance().getVelocityX() - 2);
        }
    }
}
