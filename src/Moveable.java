import javafx.stage.Stage;

public interface Moveable {
    public enum Direct {
        LEFT, RIGHT;
    }
     void move(Direct direct,Stage stage) throws Exception;
}
