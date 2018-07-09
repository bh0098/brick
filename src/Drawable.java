import javafx.scene.Scene;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public interface Drawable {
    public final Shape shape = null;
    public void draw(Stage stage)throws Exception;
}
