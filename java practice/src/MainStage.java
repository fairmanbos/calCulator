import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainStage extends Application {

    @Override
    public void start (Stage Calorie_calculator) throws Exception{

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            Scene scene = new Scene(root);
            Calorie_calculator.setTitle("Calorie Calculator");
            Calorie_calculator.getIcons().add(new Image("diet_icon.png"));
            Calorie_calculator.setScene(scene);
            Calorie_calculator.show();
        }

        catch (Exception e){
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        launch(args);
    }

}
