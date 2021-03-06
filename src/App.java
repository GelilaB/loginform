import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage Stage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene= new Scene(root);
        Stage.setScene(scene);
        Stage.setTitle("Login Form");
        
        Stage.show();
    }
    
}