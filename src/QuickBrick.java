import javafx.scene.paint.Color;

public class QuickBrick extends Brick implements Drawable {
    QuickBrick(){
        super();
        super.setColor( Color.rgb(158,226,78));
    }

    @Override
    public void accident() {
        Ball.getInstance().setVelocityX(Ball.getInstance().getVelocityX()+2);
        Ball.getInstance().setVelocityY(Ball.getInstance().getVelocityY()+2);
    }
}
